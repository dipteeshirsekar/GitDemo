package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signinPage {

	public WebDriver driver;
	@FindBy(name="user[email]")
	WebElement email;
	
	@FindBy(name="user[password]")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	public signinPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLoginButton()
	{
		return loginbutton;
	}
}
