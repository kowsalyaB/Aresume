package PageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JqueryCal;

public class MrfReqApprove {
	public WebDriver driver;
	public MrfReqApprove(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p//child::a[@href='RecruiterMRF.php']")
	WebElement MrfReq;

	@FindAll({
		@FindBy(xpath="//select[@id='ApprovedByTex']//child::option")
	})
	private List<WebElement> AssignDrop;
	public List<WebElement> getAssignDrop()
	{
		return AssignDrop;
	}

	@FindBy(xpath="//input[@id='SubmitMRF']")
	WebElement SendApproval;

	public void ClickonSendApproval()
	{
		SendApproval.click();
	}

	public void ClickOnMrfReq()
	{
		MrfReq.click();
	}

	@FindBy(xpath="//input[@id='AdditionalCommentsHRText']")
	WebElement CmntsText;

	public void GetGridNum()
	{
		List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']//child::tr//td[1]"));
		for (WebElement webElement : list) {
			if(webElement.getText().equals("7"))
			{
				driver.findElement(By.xpath("//table[@class='table table-striped']//child::tr//td[7]//img")).click();
				break;
			}
		}
	}

	public void SelectDrop()
	{
		for (WebElement webElement : getAssignDrop()) {
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
							JqueryCal.DropDown(driver, 1, string2);
						}
						limit++;
					}
				}
				pos++;
			}	
		}
	}

	public void TypeCmdText(String Text)
	{
		CmntsText.sendKeys(Text);
	}
}
