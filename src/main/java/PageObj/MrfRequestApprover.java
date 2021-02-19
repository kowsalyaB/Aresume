package PageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JqueryCal;

public class MrfRequestApprover {
	public WebDriver driver;
	public MrfRequestApprover(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p//a[@href='RecruiterMRFModified.php']")
	WebElement ProcessApprover;

	public void ClickonProApp()
	{
		ProcessApprover.click();
	}

	@FindBy(xpath="//input[@id='SubmitMRF']")
	WebElement OpenPos;

	public void ClickOpenPos()
	{
		OpenPos.click();
	}

	public void PickNum()
	{
		List<WebElement> ProcessGrid=driver.findElements(By.xpath("//table[@class='table table-striped']//child::tr"));
		for (int i = 1; i < ProcessGrid.size(); i++) {
			WebElement Ele=driver.findElement(By.xpath("//table[@class='table table-striped']//child::tr["+i+"]//td[1]"));
			if(Ele.getText().equals("13"))
			{
				driver.findElement(By.xpath("//table[@class='table table-striped']//child::tr["+i+"]//td[8]//img")).click();
				break;
			}
		}
	}
	
	public void AlertOk()
	{
		JqueryCal.AlertAccept(driver);
	}
}
