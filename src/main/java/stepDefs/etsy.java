package stepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.etsyPage;
 

public class etsy {
	
	private WebDriver driver;
	etsyPage ep ;
	String keyword ="wooden spoon";
	
	@Given("User in home page")
	public void user_in_home_page() {
	     WebDriverManager.chromedriver().setup();
	     driver= new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     driver.get("https://www.etsy.com/");
	     Assert.assertEquals("Etsy.com | Shop for anything from creative people everywhere", driver.getTitle());
	}

	@When("User searches for {string}")
	public void user_searches_for(String keyword) {
		this.keyword=keyword;
		ep = new etsyPage(driver);
		ep.searchBox.sendKeys(keyword+ Keys.ENTER);
		
		
	}

	@Then("Search result should be displayed")
	public void search_result_should_be_displayed() {
	   System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Wooden spoon | Etsy"));
		
	   driver.quit();
	}
}
