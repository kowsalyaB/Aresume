package PageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classUtils.JavaScriptCode;
import classUtils.JqueryCal;

public class SearchAppearance {
	public WebDriver driver;
	public SearchAppearance(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='AppName']")
	WebElement EnterName;

	@FindBy(xpath="//input[@id='SearchBtn' and @type='submit']")
	WebElement ClickOnSearchResume;

	@FindBy(xpath="//form[@id='regForm']//a[@href='MyProfile.php']//img")
	WebElement BackToDashBoard;

	@FindBy(xpath="//form[@id='regForm']//a//img")
	WebElement BackToSearch;

	@FindBy(xpath="//p[@align='center']//child::input[@id='SearchBtn' and @type='button']")
	WebElement SearchByLocation;

	@FindBy(xpath="//input[@id='SearchBtn']")
	WebElement SearchResume;

	public void Loc()
	{
		List<WebElement> getLocationText=driver.findElements(By.xpath("//select[@id='ApplicantPerLocSelect']/following::option"));
		for (WebElement webElement : getLocationText) {
			String val=webElement.toString();
			String splt[]=val.split("id='");
			int pos=1;
			for (String string : splt) {
				if(pos%2==0)
				{
					String arr[]=string.split("'");
					int limit=1;
					for (String string2 : arr) {
						if(limit%2!=0)
						{
							JqueryCal.DropDown(driver, 8, string2);
						}
						limit++;
					}
					break;
				}
				pos++;
			}
			break;
		}
	}

	public void ClickonSearchLoc()
	{
		SearchByLocation.click();
	}

	public void ClickonDashBoard()
	{
		try {
			BackToDashBoard.click();
		} catch (Exception e) {
			WebElement BacktoDash=driver.findElement(By.xpath("//form[@id='regForm']//a[@href='MyProfile.php']//img"));
			BacktoDash.click();
		}
	}

	public void ClickonBackSearch()
	{
		BackToSearch.click();
	}

	public void GetName()
	{
		JavaScriptCode.sendValues(driver, EnterName);
	}

	public void ClickOnBtn()
	{
		ClickOnSearchResume.click();
	}

	public void SelectView()
	{
		List<WebElement> GridId=driver.findElements(By.xpath("//table//tbody//tr"));

		for (int i = 1; i <= GridId.size(); i++) {
			WebElement ele=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[5]"));
			if(ele.getText().equals("Selected"))
			{
				try {
					driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[9]//img")).click();
				} catch (Exception e) {
					driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[9]//img")).click();
					System.out.println(ele.getText());
				}
				break;
			}
		}
	}

	public void SelectEdit()
	{
		List<WebElement> GridId=driver.findElements(By.xpath("//table//tbody//tr"));

		for (int i = 1; i <= GridId.size(); i++) {
			WebElement ele=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[5]"));
			if(ele.getText().equals("Selected"))
			{
				try {
					driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[7]//img")).click();
				} catch (Exception e) {
					driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[7]//img")).click();
					System.out.println(ele.getText());
				}
				break;
			}
		}
	}

	public void ClickonSearchReasume()
	{
		SearchResume.click();
	}

	public void GetValue()
	{
		List<WebElement> ListEle=driver.findElements(By.xpath("//table[@class='table table-striped']"
				+ "//child::tr"));
		System.out.println(ListEle.size());
		for (int i = 2; i < ListEle.size(); i++) {
			WebElement Namelist=driver.findElement(By.xpath("//table[@class='table table-striped']//following::tr["+i+"]"
					+ "//td[2]"));
			WebElement PosList=driver.findElement(By.xpath("//table[@class='table table-striped']//following::tr["+i+"]"
					+ "//td[3]"));
			if((Namelist.getText().contains("Nirmal"))&&(PosList.getText().contains("Publishing")))
			{
				try {
					driver.findElement(By.xpath("//table[@class='table table-striped']//following::tr["+i+"]//td[7]//img")).click();
				} catch (Exception e) {
					driver.findElement(By.xpath("//table[@class='table table-striped']//following::tr["+i+"]//td[7]//img")).click();
					System.out.println(Namelist.getText()+" "+PosList.getText());
				}
				break;
			}
		}
	}
}
