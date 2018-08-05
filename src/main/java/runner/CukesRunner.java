package runner;

import org.junit.runner.RunWith;

 
 
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumbe r-report",
				"json:target/cucumber.json"
		},
		 	 tags="api",
				features = "src/test/resources/features/api/*/", 
				glue = "stepDefs",
				dryRun=false 
)
public class CukesRunner extends AbstractTestNGCucumberTests {
	 
}


