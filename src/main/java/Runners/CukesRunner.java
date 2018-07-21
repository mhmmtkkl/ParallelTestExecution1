package Runners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		dryRun=false,
		features= {"src/test/resources/reviewSessionCode/"},
		glue = "stepDefs"
	 
		)
public class CukesRunner {
			
}