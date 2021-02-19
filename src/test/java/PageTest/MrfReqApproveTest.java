package PageTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObj.LoginPage;
import PageObj.MrfReqApprove;

public class MrfReqApproveTest extends TestBaseClass{
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
	public void MrfReqApproveTestCase()
	{
		MrfReqApprove Mrf=new MrfReqApprove(driver);

		Mrf.ClickOnMrfReq();
		Mrf.GetGridNum();
		Mrf.SelectDrop();
		Mrf.TypeCmdText(EnterString());
		Mrf.ClickonSendApproval();
		
		asrt.assertAll();
	}
	
	public String EnterString()
	{
		String RanNum=RandomStringUtils.randomAlphabetic(4);
		return(RanNum);
	}
}
