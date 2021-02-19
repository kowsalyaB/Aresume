package PageTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import PageObj.LoginPage;
import PageObj.SearchAppearance;

public class SearchAppearanceTest extends TestBaseClass{
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
	public void GetData()
	{
		SearchAppearance Sapp=new SearchAppearance(driver);
		Sapp.GetName();
		Sapp.ClickOnBtn();
		Sapp.SelectView();
		Sapp.ClickonDashBoard();
		Sapp.SelectEdit();
		Sapp.ClickonBackSearch();
		Sapp.ClickonSearchLoc();
		Sapp.Loc();
		Sapp.ClickonSearchReasume();
		Sapp.GetValue();
		Sapp.ClickonDashBoard();

		asrt.assertAll();
	}

}
