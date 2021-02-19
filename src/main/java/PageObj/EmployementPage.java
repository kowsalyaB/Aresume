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

public class EmployementPage {
	public WebDriver driver;
	public EmployementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//input[@id='CompanyNameVal']"),
		@FindBy(xpath="//input[@id='JDTextVal']")
	})
	private List<WebElement> CrntEmpandJobRole;

	public List<WebElement> getCrntEmpandJobRole() {

		return CrntEmpandJobRole;
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//input[@id='DatefromCompVal']"),
		@FindBy(xpath="//input[@id='DatefromToVal']")
	})
	private List<WebElement> DateFromTo;

	public List<WebElement> getDateFromTo() {

		return DateFromTo;
	}

	@CacheLookup
	@FindBy(xpath="//input[@id='iscurrentCompany']")
	WebElement Chkbox;

	@CacheLookup
	@FindBy(xpath="//select[@id='JobTypeSelectVal']//child::option")
	WebElement JobType;

	@CacheLookup
	@FindBy(xpath="//button[@id='nextBtn']")
	WebElement NextBtn;

	//Click on Next Button
	public void ClickNextForEmpPage()
	{
		JavaScriptCode.onClick(NextBtn, driver);
	}

	public void selectCheckbox()
	{
		if(Chkbox.isSelected()!=true)
		{
			Chkbox.click();
		}
	}

	public void EnterText(String name)
	{
		for (WebElement webElement : getCrntEmpandJobRole()) {
			webElement.sendKeys(name);
		}
	}

	public void EnterDate() 
	{
		int pos=1;
		for (WebElement webElement : getDateFromTo()) {
			if(pos==1)
			{
				webElement.click();
				webElement.sendKeys("10");
				webElement.sendKeys("12");
				webElement.sendKeys("2000");
			}
			else if(pos==2)
			{
				webElement.click();
				webElement.sendKeys("10");
				webElement.sendKeys("12");
				webElement.sendKeys("2008");
			}
		}
	}

	public void SelectjobType()
	{
		String val=JobType.toString();
		String splt[]=val.split("id='");
		int pos=1;
		for (String string : splt) {
			if(pos%2==0)
			{
				String arr[]=string.split("'");
				int Repos=1;
				for (String string2 : arr) {
					if(Repos%2!=0)
					{
						System.out.println(string2);
						JobType.click();
						JqueryCal.DropDown(driver, 3, string2);
						break;
					}
				}
			}
			pos++;
		}
	}
}
