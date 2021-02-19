package classUtils;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class JqueryCal {
	public static void Date(WebDriver driver, String yearNum, String monthVal, String Actualdate) {		
		WebElement date=driver.findElement(By.id("DOBdate"));
		date.click();
		WebElement Year=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//select[2]//option[@value='"+yearNum+"']"));
		Year.click();
		WebElement Month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[text()='"+monthVal+"']"));
		Month.click();		
		WebElement ActualDate=driver.findElement(By.xpath("//a[@class='ui-state-default'][text()='20']"));
		ActualDate.click();			
	}

	public static void DropDown(WebDriver driver,int genIndex, String Val)
	{
		WebElement dropdown=driver.findElement(By.id(Val));
		Select Drop=new Select(dropdown);
		Drop.selectByIndex(genIndex);

		List<WebElement> list=Drop.getOptions();
		List<String> ActualList=new ArrayList<String>();
		List<String> OrginalList=new ArrayList<String>();
		for (int i = 1; i <list.size(); i++) {
			ActualList.add(list.get(i).getText());
			OrginalList.add(list.get(i).getText());
		}
		Collections.sort(ActualList);

		if(ActualList.equals(OrginalList))
		{
			System.out.println("Drop Down List has Sorted");
		}
		else
		{
			System.out.println("Drop Down List has NOT SORTED");
		}
	}

	public static void ProfileRadioBtn(WebDriver driver)
	{
		for (int i = 0; i <2; i++) {
			i++;
			WebElement radio=driver.findElement(By.xpath("//div[@class='col-75']//input[@type='radio']["+i+"]"));
			if(radio.isSelected()==false)
			{
				radio.click();
				break;
			}
		}
	}

	public static void EduCheckBoxes(WebDriver driver)
	{
		List<WebElement> checkList=driver.findElements(By.xpath("//div[@id='Qualification_div' or @id='certifications_div']"
				+ "/descendant::input[@name='item_index[]']"));
		for (WebElement webElement : checkList) {
			webElement.click();
		}
	}

	public static void UploadFile(WebDriver driver) throws AWTException, InterruptedException
	{
		WebElement Upload=driver.findElement(By.id("ResumeFileDoc"));
		Actions act=new Actions(driver);
		act.moveToElement(Upload).click().build().perform();

		String s="C:\\Users\\kowsalya_1005\\Pictures\\data.txt";
		StringSelection str=new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot r=new Robot();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void AlertAccept(WebDriver driver)
	{
		Alert alrt=driver.switchTo().alert();
		alrt.accept();
	}
}
