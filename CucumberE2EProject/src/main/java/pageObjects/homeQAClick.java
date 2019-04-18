package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeQAClick {

	public WebDriver driver;
	@FindBy(css="a[href*='sign_in']")
	WebElement login;
	
	@FindBy(xpath="//h2[text()='Featured Courses']")
	////div[@class='text-center']/h2
	WebElement title;
	
	//@FindBy(xpath="//button[text()='NO THANKS']")
	//WebElement popup;
	
	//WebElement popup= driver.findElement(By.xpath("//button[text()='NO THANKS']"));
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public homeQAClick(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public int getpopupsize()
	{
		return driver.findElements(popup).size();
		System.out.println("This is changed data");
	}
	
	public WebElement getpopup()
	{
		return driver.findElement(popup);
	}
	
	public WebElement login()
	{
		return login;
	}
	
	public WebElement getTitle()
	{
		return title;
	}
}
