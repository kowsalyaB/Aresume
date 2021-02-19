package PageTest;

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
import PageObj.SkillsPage;

public class SkillsTest extends TestBaseClass{
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
		
		EmployementPage EmPage=new EmployementPage(driver);
		EmPage.ClickNextForEmpPage();
	}
	
	@Test
	public void SkillTestCase() throws IOException
	{
		SkillsPage Spage=new SkillsPage(driver);
		
		Spage.EnterText(EnterString());
		Spage.CheckBoxClick();
		Spage.Skillexp(String.valueOf(EnterNumber()));
		Spage.SelectDrop();
		Spage.ClickNextForSkillsPage();
		
		String Title=AssPageTitle();
		if(Title.equals("Add Applicant - Assessment"))
		{
			Assert.assertTrue(true);
			logger.info("Succesfully Completed Skills Page");
		}
		else
		{
			captureScreen(driver,"EmpTest");
			asrt.assertFalse(false);
			logger.info("Not succesfully Completed Skills Page");
		}
		
		asrt.assertAll();
	}
	
	public String EnterString()
	{
		String RanNum=RandomStringUtils.randomAlphabetic(4);
		return(RanNum);
	}
	
	public String EnterNumber()
	{
		String Ranval=RandomStringUtils.randomNumeric(2);
		return(Ranval);
	}
	
	public String AssPageTitle()
	{
		String Title=driver.findElement(By.xpath("//h3[text()='Add Applicant - Assessment']")).getText();
		return Title;
	}
}
