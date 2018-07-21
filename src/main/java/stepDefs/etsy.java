package stepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.etsyPage;
 

public class etsy {
	
	private WebDriver etsyPage;
	etsyPage ep ;
	
	
	@Given("User in home page")
	public void user_in_home_page() {
	     WebDriverManager.chromedriver().setup();
	     driver= new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.manage().window().fullscreen();
	     driver.get("https://www.etsy.com/");
	     Assert.assertEquals("Etsy.com | Shop for anything from creative people everywhere", driver.getTitle());
	}

	@When("User searches for {string}")
	public void user_searches_for(String string) {
		ep = new etsyPage(etsyPage);
		
	}

	@Then("Search result should be displayed")
	public void search_result_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
