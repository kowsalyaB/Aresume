package PageTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObj.LoginPage;
import PageObj.MrfRequestApprover;

public class MrfRequestApproverTest extends TestBaseClass{
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
	}

	@Test
	public void MrfApproverTestCase()
	{
		MrfRequestApprover Mapprover=new MrfRequestApprover(driver);

		Mapprover.ClickonProApp();
		Mapprover.PickNum();
		Mapprover.ClickOpenPos();
		Mapprover.AlertOk();

		asrt.assertAll();
	}
}
