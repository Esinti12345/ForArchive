package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Attribution.feature"
		,glue="/Users/ahmetorhan/eclipse-workspace/ZExercise/src/test/java/steps"
		//,dryRun=true
		,monochrome=true
		,tags= {"@tag1"}    
		,plugin = {"pretty", "html:target/cucumber-default-reports", "json:target/cucumber.json"}
		)

public class TestRunner  { 

}
