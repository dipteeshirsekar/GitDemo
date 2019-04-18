package Framework.E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.homeQAClick;
import pageObjects.signinPage;
import resources.Base;

public class validateTitle extends Base{
	public static Logger log= LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		System.out.println("Initializing a browser");
		driver=initializeBrowser();
		log.debug("Browser is launched");
		driver.get(p.getProperty("url"));
		log.info("URL is opened successfully");
	}
	
	@Test
	public void verifyTitle() throws IOException
	{
		
	homeQAClick h= new homeQAClick(driver);
	Assert.assertEquals(h.getTitle().getText(),"FEATURED COURSES");
	log.info("Title is validated successfully");
	//if(h.getTitle().getText().equals("FEATURED COURSES"))
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
		log.info("Browser is closed");
	}
	
	@Test
	public void demo1()
	{
		
		log.info("Browser is closed");
	}
	
}
