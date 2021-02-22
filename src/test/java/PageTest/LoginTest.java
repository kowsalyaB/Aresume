package PageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObj.LoginPage;

public class LoginTest extends TestBaseClass {
	@BeforeMethod
	public void GetUrl()
	{
		logger.info("URL has opend");
		driver.get(URL);	
	}
	@Test
	public void Logintest() throws IOException
	{
		LoginPage login=new LoginPage(driver);
		logger.info("Entered the username");
		login.setUserName(UserName);
		logger.info("Entered the password");
		login.setPassWord(PassWord);
		logger.info("Selected value from dropdown");
		login.selectRole("Recruiter");
		logger.info("Clicked on the submit button");
		login.Submit();
		logger.info("Get teh title");
		String titile=driver.getTitle();
		logger.info("Thru assert condition it's checked");
		if(driver.getTitle().equals("Applicant Tracker"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"Logintest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		System.out.println("Title Page is :"+titile);
	}
	@AfterMethod
	public void DeleteCookies()
	{
		driver.manage().deleteAllCookies();
	}
}
