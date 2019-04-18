package Framework.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.homeQAClick;
import pageObjects.signinPage;
import resources.Base;

public class clickLogin extends Base{
	
	
	@Test(dataProvider="getData")
	public void goToHomePage(String uname, String pass) throws IOException
	{ 
	driver=initializeBrowser();
	driver.get(p.getProperty("url"));
	homeQAClick h= new homeQAClick(driver);
	//if(h.getTitle().getText().equals("FEATURED COURSES"))
		Assert.assertEquals("FEATURED COURSESA", h.getTitle().getText());
	
		h.login().click();
	
	signinPage s= new signinPage(driver);
	s.getEmail().sendKeys(uname);
	s.getPassword().sendKeys(pass);
	s.getLoginButton().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		//here row=no. of times we want test to be run
		//columns= no. of parameters you will be passing
		//1st row
		data[0][0]="user1";
		data[0][1]="def";
		
		//2nd row
		data[1][0]="user2";
		data[1][1]="hello";
				
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
