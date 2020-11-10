package org.AcurusResume.Pageobj;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	WebDriver driver;
	public LoginClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="username")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement PassWord;
	
	@FindBy(id="group")
	WebElement Role;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement SignIn;
	
	@FindBy(xpath="//a//img")
	WebElement LogOut;
	
	public void setUserName(String Name)
	{
		UserName.sendKeys(Name);
	}
	public void setPassWord(String Pass)
	{
		PassWord.sendKeys(Pass);
	}
	public void selectRole(String DropRole)
	{
		Role.sendKeys(Keys.ENTER+DropRole+Keys.ENTER);
	}
	public void Submit()
	{
		SignIn.click();
	}
	public void Logout()
	{
		LogOut.click();
	}
	
	
	
}
