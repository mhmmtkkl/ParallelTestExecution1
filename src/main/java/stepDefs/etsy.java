package stepDefs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.etsyPage;

public class etsy {

	private WebDriver driver;
	etsyPage etsy;
	String keyword = "wooden spoon";
	
	public static final String USERNAME = "comals";
	public static final String ACCESS_KEY = "b6396590-e312-4b90-95eb-41e6a28b0ece";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	DesiredCapabilities caps;
	 
	 
//	String Scenerio = Scenerio.getname();
	

	@And("User in home page")
	public void user_in_on_Etsy_homepage() throws MalformedURLException {
		  	caps = new DesiredCapabilities();
	 	 	
			caps.setCapability("name", "mhmmt");
			caps.setCapability("access-key", ACCESS_KEY);
			caps.setCapability("platform", "Linux");
			caps.setCapability("browserName", "Chrome" );
			caps.setCapability("version", "latest");
			caps.setCapability("passed", "true");
			
		 driver = new RemoteWebDriver(new URL(URL),caps);
		  driver.manage().window().fullscreen();
		  
		
 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://etsy.com");
		Assert.assertEquals("Etsy.com | Shop for anything from creative people everywhere", driver.getTitle());
	}

	@When("User searches for {string}")
	public void user_searches_for(String keyword) {
		this.keyword = keyword;
		etsy = new etsyPage(driver);
		etsy.searchBox.sendKeys(keyword + Keys.ENTER);
		System.out.println("SEARCHING FOR " + keyword);

	}

	@Then("Search result should be displayed")
	public void search_result_should_be_displayed() {
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().toLowerCase().contains(keyword));

		driver.quit();
	}

}
