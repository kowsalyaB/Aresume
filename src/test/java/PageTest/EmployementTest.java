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
import PageObj.EmployementPage;
import PageObj.LoginPage;

public class EmployementTest extends TestBaseClass{
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
		
		EducationPage Epage=new EducationPage(driver);
		Epage.ClickNextForEduPage();
	}
	
	@Test
	public void EmpTest() throws IOException
	{
		EmployementPage EmpPage=new EmployementPage(driver);
		EmpPage.selectCheckbox();
		EmpPage.EnterText(EnterString());
		EmpPage.EnterDate();
		EmpPage.SelectjobType();
		EmpPage.ClickNextForEmpPage();
		
		String Title=SkillPageTitle();
		if(Title.equals("Add Applicant - Skills"))
		{
			Assert.assertTrue(true);
			logger.info("Succesfully Completed Employement Page");
		}
		else
		{
			captureScreen(driver,"EmpTest");
			asrt.assertFalse(false);
			logger.info("Not succesfully Completed Employement Page");
		}
		
		asrt.assertAll();
	}
	
	public String EnterString()
	{
		String Ranval=RandomStringUtils.randomAlphabetic(4);
		return(Ranval);
	}
	
	public String SkillPageTitle()
	{
		String Title=driver.findElement(By.xpath("//h3[text()='Add Applicant - Skills']")).getText();
		return Title;
	}
}
