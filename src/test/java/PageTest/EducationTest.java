package PageTest;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObj.AddApplicantDemo;
import PageObj.EducationPage;
import PageObj.LoginPage;

public class EducationTest extends TestBaseClass{
	SoftAssert asrt=new SoftAssert();
	
	@BeforeMethod
	public void GetUrl()
	{
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.setUserName(UserName);
		login.setPassWord(PassWord);
		login.selectRole("Recruiter");
		login.Submit();

		AddApplicantDemo DemoPage=new AddApplicantDemo(driver);
		DemoPage.FlasNewAppBtnandClick();
		logger.info("Entered Firstname Lastname Middlename");
		DemoPage.EnterFiLaMiName("Kowsalya","Balasubra","Maniam");
		logger.info("Entered DOB");
		DemoPage.DateOfBirth();	
		DemoPage.ClickNextForAddAppDemo();
	}
	@Test
	public void EduTest() throws AWTException, InterruptedException, IOException
	{
		EducationPage edu=new EducationPage(driver);
		edu.SelectEduCheck();
		edu.SelectQualandSpecial();
		edu.ScrollHeight();
		edu.CerName(RandomStrings());
		edu.Graduation();
		edu.ClickNextForEduPage();

		String PageTitle=EmpPageTitle();
		if(PageTitle.equals("Add Applicant - Employment History"))
		{
			Assert.assertTrue(true);
			logger.info("Succesfully Completed Education Page");
		}
		else
		{
			captureScreen(driver,"EduTest");
			asrt.assertFalse(false);
			logger.info("Not succesfully Completed Education Page");
		}
		
		asrt.assertAll();
	}

	public String RandomStrings()
	{
		String GenerateString=RandomStringUtils.randomAlphabetic(8);
		return GenerateString;
	}

	public String EmpPageTitle()
	{
		String Title=driver.findElement(By.xpath("//h3[normalize-space(text()) = 'Add Applicant - Employment History']")).getText();
		return Title;
	}
}
