package org.AcurusResume.PageTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.AcurusResume.classUtilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseClass {

	ReadConfig configPro=new ReadConfig();
	public String URL=configPro.GetApplicationUrl();
	public String UserName=configPro.GetUserName();
	public String PassWord=configPro.GetPassWord();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browsername")
	@BeforeClass
	public void setUp(String browser)
	{
		logger=Logger.getLogger("AcurusResume");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Launch the browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", configPro.GetChromedriver());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			driver=new ChromeDriver(options);
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", configPro.GetChromedriver());
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver", configPro.GetChromedriver());
			driver=new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterClass public void tearDown() { logger.info("Quit the browser");
	driver.quit(); }

	public static void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

}
