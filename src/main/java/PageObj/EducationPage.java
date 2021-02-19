package PageObj;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JavaScriptCode;
import classUtils.JqueryCal;
import classUtils.ReadConfig;

public class EducationPage{
	public WebDriver driver;
	public EducationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll
	({
		@FindBy(xpath="//input[@name='YearofGraduation[]']"),
		@FindBy(xpath="//input[@id='RenewalDate']")
	})
	private List<WebElement> YearofGradutaion;

	public List<WebElement> GetYearofGradutaion() {

		return YearofGradutaion;
	}

	@CacheLookup
	@FindBy(id="InputCertifications[]")
	WebElement CertificateName;

	@CacheLookup
	@FindBy(xpath="//button[@id='nextBtn']")
	WebElement NextBtn;

	public void SelectEduCheck()
	{
		JqueryCal.EduCheckBoxes(driver);
	}

	public void SelectQualandSpecial()
	{
		JqueryCal.DropDown(driver, 5, "ApplicantQualificationsSelect");
		JqueryCal.DropDown(driver, 6, "ApplicantSpecializationSelect");
	}

	public void Graduation() throws AWTException
	{
		int pos=0;
		for (WebElement webElement : GetYearofGradutaion()) {
			pos++;
			if(pos==1)
			{
				webElement.click();
				webElement.sendKeys("s");
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				webElement.sendKeys("2018");
			}
			else if(pos==2)
			{
				webElement.click();
				webElement.sendKeys("Mar");
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				webElement.sendKeys("2019");
			}
		}
	}
	public void CerName(String name)
	{
		CertificateName.sendKeys(name);
	}

	public void ScrollHeight()
	{
		JavaScriptCode.ScrollDown(driver);
	}

	//Click on Next Button
	public void ClickNextForEduPage()
	{
		JavaScriptCode.onClick(NextBtn, driver);
	}
}
