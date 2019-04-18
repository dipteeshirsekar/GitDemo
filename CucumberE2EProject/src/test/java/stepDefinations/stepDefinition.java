package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.PortalHomePage;
import pageObjects.homeQAClick;
import pageObjects.signinPage;
import resources.Base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {

    @Given("^Browser is initialized$")
    public void browser_is_initialized() throws Throwable {
    	driver=initializeBrowser();
    	
    }


    @Then("^User is successfully logged in$")
    public void user_is_successfully_logged_in() throws Throwable {
    	PortalHomePage ph= new PortalHomePage(driver);
    	Assert.assertTrue(ph.getsearchtextbox().isDisplayed());
    	
    	driver.quit();
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Click on Login Link in HomePage$")
    public void click_on_login_link_in_homepage() throws Throwable {
    	homeQAClick h= new homeQAClick(driver);
    	//Assert.assertEquals("FEATURED COURSESA", h.getTitle().getText());
    	if(h.getpopupsize()>0)
    	{
    		h.getpopup().click();
    	}
    	
		h.login().click();
    }
    
    @When("^User enters (.+) and (.+) then clicks Login$")
    public void user_enters_and_then_clicks_login(String username, String password) throws Throwable {
    	signinPage s= new signinPage(driver);
    	s.getEmail().sendKeys(username);
    	s.getPassword().sendKeys(password);
    	s.getLoginButton().click();
    }

}