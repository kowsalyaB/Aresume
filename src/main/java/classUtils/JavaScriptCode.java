package classUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptCode {
	
	//Flashing on element
	public static void flash(WebElement element,WebDriver driver)
	{
		//JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<15;i++)
		{
			changecolor("#000000", element, driver);
			changecolor(bgcolor, element, driver);
		}
	}
	public static void changecolor(String color,WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//Select date
	public static void SelectdateByJs(WebDriver driver, WebElement DateEle,String DateVal)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+DateVal+"');",DateEle);	
	}

	//Click on some element
	public static void onClick(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	
	//Scroll Down option
	public static void ScrollDown(WebDriver driver)
	{
	JavascriptExecutor js=((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
