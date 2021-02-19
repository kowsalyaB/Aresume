package PageTest;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObj.AddApplicantDemo;
import PageObj.AssessmentPage;
import PageObj.EducationPage;
import PageObj.EmployementPage;
import PageObj.LoginPage;
import PageObj.SkillsPage;

public class AssessmentTest extends TestBaseClass{
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

		SkillsPage Spage=new SkillsPage(driver);
		Spage.ClickNextForSkillsPage();
	}

	@Test
	public void AssessmentTestCase() throws IOException
	{
		AssessmentPage Apage=new AssessmentPage(driver);

		Apage.ClickPrev();
		Apage.ClickNext();
		Apage.DropdownSelect();
		Apage.FieldsText(EnterString());
		Apage.NumText(Integer.parseInt(EnterNumber()));
		Apage.ClickNext();
		String Eleis=Text();
		if(Eleis.contains("Offer Letter Status"))
		{
			asrt.assertTrue(true);
			System.out.println("Successfully has submitted the resume...");
		}
		else
		{
			asrt.assertFalse(false);
			captureScreen(driver, "AssessmentTestCase");
			System.out.println("Not successfully has submitted the resume...");
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

	public String Text()
	{
		WebElement ele=driver.findElement(By.xpath(" //table//th[normalize-space(text()) = 'Offer Letter Status']"));
		return ele.getText();
	}
}
