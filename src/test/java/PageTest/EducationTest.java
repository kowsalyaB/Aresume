package PageTest;

import java.awt.AWTException;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObj.AddApplicantDemo;
import PageObj.EducationPage;
import PageObj.LoginPage;

public class EducationTest extends TestBaseClass{
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
		DemoPage.ClickNext();
	}
	@Test
	public void EduTest() throws AWTException, InterruptedException
	{
		EducationPage edu=new EducationPage(driver);
		edu.SelectEduCheck();
		edu.SelectQualandSpecial();
		edu.ScrollHeight();
		edu.CerName(RandomStrings());
		edu.Graduation();
	}

	public String RandomStrings()
	{
		String GenerateString=RandomStringUtils.randomAlphabetic(8);
		return GenerateString;
	}
}
