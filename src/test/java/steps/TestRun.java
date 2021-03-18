package steps;




import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun=false,
		features = "src/test/resource",
		glue={"steps"},
		tags = "@example",
		format = {
					"pretty",
					"html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
		})

public class TestRun {

}

