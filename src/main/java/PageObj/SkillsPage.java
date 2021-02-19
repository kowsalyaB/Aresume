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

public class SkillsPage {
	public WebDriver driver;
	public SkillsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath="//input[@id='DelSkillData']")
	WebElement Chkbox;

	@CacheLookup
	@FindBy(xpath="//input[@id='ExpMonthsSkill']")
	WebElement SkillExp;

	@CacheLookup
	@FindBy(xpath="//input[@id='SoftSkillsText']")
	WebElement SoftSkills;

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//select[@id='ApplicantSkillsSelect']"),
		@FindBy(xpath="//select[@id='CompanySkillsSelect']"),
		@FindBy(xpath="//select[@id='isSkillcurrentlyUsed']")
	})
	private List<WebElement> KeykillsUsed;

	public List<WebElement> getKeykillsUsed() {

		return KeykillsUsed;
	}

	@CacheLookup
	@FindBy(xpath="//button[@id='nextBtn']")
	WebElement NextBtn;

	//Click on Next Button
	public void ClickNextForSkillsPage()
	{
		JavaScriptCode.onClick(NextBtn, driver);
	}

	public void CheckBoxClick()
	{
		Chkbox.click();
	}

	public void SelectDrop()
	{
		for (WebElement webElement : getKeykillsUsed()) {
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
							JqueryCal.DropDown(driver, 2, string2);
						}
						limit++;
					}
				}
				pos++;
			}	
		}
	}

	public void EnterText(String Name)
	{
		SoftSkills.sendKeys(Name);
	}

	public void Skillexp(String Num)
	{
		SkillExp.sendKeys(Num);
	}
}
