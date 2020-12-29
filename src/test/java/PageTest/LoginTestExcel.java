package PageTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObj.LoginPage;
import classUtils.XlUtils;

public class LoginTestExcel extends TestBaseClass{
	@BeforeMethod
	public void GetUrl()
	{
		logger.info("URL has opend");
		driver.get(URL);	
	}

	@Test(dataProvider = "LoginData")
	public static void LoginDDT(String UserName, String PassWord, String Role) throws IOException
	{
		LoginPage Login=new LoginPage(driver);
		logger.info("Entered UserName");
		Login.setUserName(UserName);
		logger.info("Entered PassWord");
		Login.setPassWord(PassWord);
		logger.info("Selected Role");
		Login.selectRole(Role);

		Login.Submit();
		if(driver.getTitle().equals("Applicant Tracker"))
		{
			logger.info("Login Passed");
			Login.Logout();
			System.out.println("Valid Login :"+UserName+" "+PassWord+" "+Role);
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "LoginDDT");
			CheckLogin();
			System.out.print(" "+UserName+" "+PassWord+" "+Role);
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}

	}

	public static void CheckLogin()
	{
		try
		{
			String InvalidLogin=driver.findElement(By.xpath("//form[@id='login-form']//child::center//h5")).getText();
			if(InvalidLogin.equals("User Name Or Password Invalid!"))
			{
				System.out.println("Invalid Login :");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/UtilsPage/LoginDatas.xlsx";
		int rowCount=XlUtils.getRowCount(path, "Sheet1");
		int colCount=XlUtils.getCellCount(path, "Sheet1", 1);

		String LoginData[][]=new String[rowCount][colCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				LoginData[i-1][j]=XlUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return LoginData;
	}

	@AfterMethod
	public void DeleteCookies()
	{
		driver.manage().deleteAllCookies();
	}

}
