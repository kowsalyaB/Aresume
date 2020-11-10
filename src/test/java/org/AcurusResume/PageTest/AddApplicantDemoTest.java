package org.AcurusResume.PageTest;

import java.awt.AWTException;
import java.io.IOException;

import org.AcurusResume.Pageobj.AddApplicantDemo;
import org.AcurusResume.Pageobj.LoginClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class AddApplicantDemoTest extends TestBaseClass{

	SoftAssert Asrt=new SoftAssert();

	@BeforeMethod
	public void GetUrl()
	{
		logger.info("URL has opend");
		driver.get(URL);
		LoginClass login=new LoginClass(driver);
		login.setUserName(UserName);
		login.setPassWord(PassWord);
		login.selectRole("Recruiter");
		login.Submit();
	}

	@Test
	public void AddApplicantTest() throws AWTException, InterruptedException, IOException {
		AddApplicantDemo DemoPage=new AddApplicantDemo(driver);

		logger.info("Get the Main Page Inner Text");
		String InnerText=DemoPage.GetInerPageText();
		if(InnerText.equals("Acurus Applicant Tracker"))
		{
			Asrt.assertTrue(true);
			logger.info("Succefully matched Main page inner titile");
		}
		else
		{
			captureScreen(driver,"AddApplicantTest");
			Asrt.assertFalse(false);
			logger.info("Not succefully matched Main page inner titile");
		}

		logger.info("Add Applicant Button got flashed and clicked");
		DemoPage.FlasNewAppBtnandClick();
	
		logger.info("Get Demo Page Title");
		String demoPageInnerText=DemoPage.demoPageTitle();
		if(demoPageInnerText.equals("Add Applicant"))
		{
			Asrt.assertTrue(true);
			logger.info("Succefully matched Demo page inner titile");
		}
		else
		{
			captureScreen(driver,"AddApplicantTest");
			Asrt.assertFalse(false);
			logger.info("Not succefully matched Demo page inner titile");
		}

		logger.info("Clear Date Field and Entered Date");
		DemoPage.DateClearandEnterDate();

		logger.info("Entered Firstname Lastname Middlename");
		DemoPage.EnterFiLaMiName("Kowsalya","Balasubra","Maniam");

		logger.info("Entered DOB");
		DemoPage.DateOfBirth();

		logger.info("Entered Primar, Secondary Number, Email, Address1 and Address2");
		String EmailId=RandomString()+"@gmail.com";
		DemoPage.PriSecNum("7812742867", "5745212859", EmailId, "366-c block" , "kandhanchanavi chennai-600096");

		logger.info("Seleted Country, State, Gender, Maritial, MRF from Drop Down");	
		DemoPage.ConStGenMarMRFDrop();

		logger.info("Entered City and PinCode");	
		DemoPage.CityPincode("Chennai", 637211);

		logger.info("Selected Profile Freshness Radio Button");
		DemoPage.ProfileRadio();

		logger.info("Entered Total Exp, Relevant Exp, Current CTC Per Month, Current Loc, Linkedin Pro, FaceBook Pro");
		DemoPage.ExpLocProfile(2.6f, 2.5f, 2500000, "Namakkal", "https://Linkedin.com", "https://facebook.com", 1.5f);

		logger.info("Checked Project name has enabled/disabled");
		Asrt.assertFalse(DemoPage.Project());

		logger.info("Checked and select Position Applied, Job Type, Department and Applicant Source");
		DemoPage.PosJobDepAppSrc();

		logger.info("Uploaded File");
		Thread.sleep(3000); 
		DemoPage.UploadNewFile();
		
		logger.info("Click on Next Button");
		DemoPage.ClickNext();
		
		String PageColor=EduPageImgClr();
		if(PageColor.equals("green"))
		{
			Assert.assertTrue(true);
			logger.info("Succesfully Completed First Demo Page");
		}
		else
		{
			captureScreen(driver,"AddApplicantTest");
			Asrt.assertFalse(false);
			logger.info("Not succesfully Completed First Demo Page");
		}
		
		Asrt.assertAll();
	}

	@AfterMethod
	public void deleteAllCookie()
	{
		driver.manage().deleteAllCookies();
	}
	
	public String RandomString()
	{
		String GenerateString=RandomStringUtils.randomAlphabetic(8);
		return GenerateString;
	}
	
	public String EduPageImgClr()
	{
		String color=driver.findElement(By.xpath("//h3[text()='Add Applicant - Qualification(s)']")).getCssValue("color");
		return color;
	}
}

