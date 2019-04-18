package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Base {
	public static WebDriver driver;
	public Properties p;
	@Test
	public WebDriver initializeBrowser() throws IOException
	{
		p= new Properties();
		FileInputStream fis= new FileInputStream("G:\\gayatri\\workspaces\\practice_05_Jan_2018\\E2EProject\\src\\main\\java\\resources\\data.properties");
		p.load(fis);
		String browserName=p.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:/gayatri/Selenium/chromedriver_win32/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:/gayatri/Selenium/geckodriver-v0.21.0-win64/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String string) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\gayatri\\Selenium\\test"+string+"screeshot.jpg"));
	}
}
