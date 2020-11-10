package org.AcurusResume.PageTest;

import java.io.IOException;

import org.AcurusResume.Pageobj.LoginClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBaseClass{
	@BeforeMethod
	public void GetUrl()
	{
		logger.info("URL has opend");
		driver.get(URL);	
	}
	@Test
	public void Logintest() throws IOException
	{
		LoginClass login=new LoginClass(driver);
		logger.info("Entered username");
		login.setUserName(UserName);
		logger.info("Entered password");
		login.setPassWord(PassWord);
		logger.info("Selected value from dropdown");
		login.selectRole("Recruiter");
		logger.info("Clicked submit button");
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
