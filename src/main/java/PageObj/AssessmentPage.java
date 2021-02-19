package PageObj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JavaScriptCode;
import classUtils.JqueryCal;

public class AssessmentPage {
	public WebDriver driver;
	public AssessmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//select[@id='ApplicantHRCommentsSelect']"),
		@FindBy(xpath="//select[@id='HRRating']"),
		@FindBy(xpath="//select[@id='ApplicantTechCommentsSelect']"),
		@FindBy(xpath="//select[@id='TechRate']"),
		@FindBy(xpath="//select[@id='CandidateStatus']"),
		@FindBy(xpath="//select[@id='OfferLetterStatusSelect']")
	})
	private List<WebElement> AssessDrop;

	public List<WebElement> getAssessDrop() {

		return AssessDrop;
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//input[@id='HRAddRemarks']"),
		@FindBy(xpath="//input[@id='TechAddRemarks']"),
		@FindBy(xpath="//input[@id='CandidateFinalComments']"),
		@FindBy(xpath="//select[@id='TechRate']"),
		@FindBy(xpath="//input[@id='HiringDeptCOmmentVal']")
	})
	private List<WebElement> AssessFieldsText;

	public List<WebElement> getAssessFieldsText() {

		return AssessFieldsText;
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//input[@id='AnnualExpectedCTC']"),
		@FindBy(xpath="//input[@id='AnnualApprovedCTC']")
	})
	private List<WebElement> AssessFieldsNum;

	public List<WebElement> getAssessFieldsNum() {

		return AssessFieldsNum;
	}

	@CacheLookup
	@FindBy(xpath="//button[@id='nextBtn']")
	WebElement NextBtn;

	//Click on Next Button
	public void ClickNext()
	{
		JavaScriptCode.onClick(NextBtn, driver);
	}

	@CacheLookup
	@FindBy(xpath="//button[@id='prevBtn']")
	WebElement PrevBtn;

	//Click on Prev Button
	public void ClickPrev()
	{
		JavaScriptCode.onClick(PrevBtn, driver);
	}

	public void DropdownSelect()
	{
		for (WebElement webElement : getAssessDrop()) {
			String val=webElement.toString();
			String splt[]=val.split("id='");
			int pos=1;
			for (String string : splt) {
				if(pos%2==0)
				{
					int limit=1;
					String arr[]=string.split("'");
					for (String string2 : arr) {
						if(limit%2!=0)
						{
							if(string2.contains("CandidateStatus"))
							{
								JqueryCal.DropDown(driver, 1, string2);
							}
							else
							{
								JqueryCal.DropDown(driver, 2, string2);
							}	
						}
						limit++;
					}
				}
				pos++;
			}	
		}
	}

	public void FieldsText(String name)
	{
		for (WebElement webElement : getAssessFieldsText()) {
			webElement.sendKeys(name);
		}
	}

	public void NumText(int num)
	{
		for (WebElement webElement : getAssessFieldsNum()) {
			//can use string builder and string buffer
			webElement.sendKeys(String.valueOf(num));
		}
	}
	
	public void MovePrev()
	{
		for (int i = 0; i < 4; i++) {
			ClickPrev();
		}
	}
	
	public void MoveNext()
	{
		for (int i = 0; i < 4; i++) {
			ClickNext();
		}
	}
}

