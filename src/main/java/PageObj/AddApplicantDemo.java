package PageObj;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JavaScriptCode;
import classUtils.JqueryCal;
import classUtils.ReadConfig;

public class AddApplicantDemo extends ReadConfig{
	static WebDriver driver;
	public AddApplicantDemo(WebDriver driver) {
		AddApplicantDemo.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath="//body//h2")
	WebElement PageText;

	@CacheLookup
	@FindBy(xpath="//input[@id='ViewQueue' and @class='button'][1]")
	WebElement AddAppBtn;

	@CacheLookup
	@FindBy(xpath="//form[@id='regForm']//child::h1")
	WebElement GetDemoPageTitle;

	@CacheLookup
	@FindBy(id="RAF")
	WebElement Dateclear;

	String Dateval=prob.getProperty("Date");

	@CacheLookup
	@FindBy(id="fname")
	WebElement FirstName;

	@CacheLookup
	@FindBy(id="lname")
	WebElement LastName;

	@CacheLookup
	@FindBy(id="MiddleName")
	WebElement MiddleName;

	@CacheLookup
	@FindBy(id="PhoneNoText")
	WebElement PrimaryNo;

	@CacheLookup
	@FindBy(id="SecPhoneNo")
	WebElement SecondaryNo;

	@CacheLookup
	@FindBy(id="EmailText")
	WebElement Email;

	@CacheLookup
	@FindBy(id="AddLine1TExt")
	WebElement Address1;

	@CacheLookup
	@FindBy(id="AddLine2Text")
	WebElement Address2;

	@CacheLookup
	@FindBy(id="CityText")
	WebElement City;

	@CacheLookup
	@FindBy(id="Pincode")
	WebElement Pincode;

	@CacheLookup
	@FindBy(id="ExperienceMonths")
	WebElement TotalExp;

	@CacheLookup
	@FindBy(id="RelExperienceMonths")
	WebElement RelevantExp;

	@CacheLookup
	@FindBy(id="ANNualCurrentCTC")
	WebElement CurrentCTC;

	@CacheLookup
	@FindBy(id="Location")
	WebElement Currentloc;

	@CacheLookup
	@FindBy(id="LinkedinProf")
	WebElement LinkedinPro;

	@CacheLookup
	@FindBy(id="facebookpf")
	WebElement FaceBookPro;

	@CacheLookup
	@FindBy(id="ProjNameText")
	WebElement ProName;

	@CacheLookup
	@FindBy(id="NoticePeriod")
	WebElement NoticePer;

	@CacheLookup
	@FindBy(id="nextBtn")
	WebElement NextBtn;

	//Once opened Get the Title of Inner page "Acurus Applicant Tracker"
	public String GetInerPageText()
	{
		String InnerText=PageText.getText();
		return InnerText;
	}

	//Make it flash NewApplicant button and click
	public void FlasNewAppBtnandClick()
	{
		JavaScriptCode.flash(AddAppBtn, driver);
		AddAppBtn.click();
	}

	//Once opend get the demo page title "Add Applicant"
	public String demoPageTitle()
	{
		String DemoPgeTitleIs=GetDemoPageTitle.getText();
		return DemoPgeTitleIs;
	}

	//Place the Date in Resume As Of* field
	public void DateClearandEnterDate()
	{
		JavaScriptCode.SelectdateByJs(driver, Dateclear, Dateval);	
	}

	//Enter First Name, Last Name and Middle name
	public void EnterFiLaMiName(String Fname, String Lname, String Mname)
	{
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		MiddleName.sendKeys(Mname);
	}

	//Place date in DOB field
	public void DateOfBirth()
	{
		JqueryCal.Date(driver,"2000","Jan","15");
	}

	//Enter Primary, Secondary phone number, Email, Adress1 and Address2
	public void PriSecNum(String PriNum, String SecNum, String email, String Add1, String Add2)
	{
		PrimaryNo.sendKeys(PriNum);
		SecondaryNo.sendKeys(SecNum);
		Email.sendKeys(email);
		Address1.sendKeys(Add1);
		Address2.sendKeys(Add2);
	}

	//Check and select Gender, Country, State, Maritial, MRF Drop Down
	public void ConStGenMarMRFDrop()
	{
		JqueryCal.DropDown(driver, 2,"Genderselect");
		JqueryCal.DropDown(driver, 2,"CountryText");
		JqueryCal.DropDown(driver, 2,"StateText");
		JqueryCal.DropDown(driver, 2,"SelectMaritalStatus");
		JqueryCal.DropDown(driver, 2,"MRFText");
	}

	//Place City and PinCode
	public void CityPincode(String CityName, long PinCodeNum)
	{
		City.sendKeys(CityName);
		Pincode.sendKeys(Long.toString(PinCodeNum));
	}

	//Check Profile Freshness Radio button
	public void ProfileRadio()
	{
		JqueryCal.ProfileRadioBtn(driver);
	}

	//Enter Total ,Relevant exp, CurrentCTC, CurrentLoc, LinkedinPro, FacebookPro and Notice Period
	public void ExpLocProfile(float TotalEx, float RelevantEx, long CrntCtc, String CrntLoc, String LinkedPro, String FacebkPro, float Notice)
	{
		TotalExp.sendKeys(Float.toString(TotalEx));
		RelevantExp.sendKeys(Float.toString(RelevantEx));
		CurrentCTC.sendKeys(Long.toString(CrntCtc));
		Currentloc.sendKeys(CrntLoc);
		LinkedinPro.sendKeys(LinkedPro);
		FaceBookPro.sendKeys(FacebkPro);
		NoticePer.sendKeys(Float.toString(Notice));
	}

	//Check Project Name field has enabled or not
	public boolean Project() 
	{
		return ProName.isEnabled();
	}

	//Check and select Position Applied, Job Type, Department and Applicant Source
	public void PosJobDepAppSrc()
	{
		JqueryCal.DropDown(driver, 2,"SelectPositionApplied");
		JqueryCal.DropDown(driver, 2,"CandidateJobTypeCombo");
		JqueryCal.DropDown(driver, 2,"PositionAppliedDeptSelect");
		JqueryCal.DropDown(driver, 2,"ApplicantSourceSelect");
	}

	//Upload file
	public void UploadNewFile() throws AWTException, InterruptedException {
		JqueryCal.UploadFile(driver);
	}

	//Click on Next Button
	public void ClickNext()
	{
		JavaScriptCode.onClick(NextBtn, driver);
	}
	
	//Scroll Till End
	public void ScrollHeightinDemo()
	{
		JavaScriptCode.ScrollDown(driver);
	}
}
