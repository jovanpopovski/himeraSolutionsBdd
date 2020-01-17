package resources;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"resources.features.SauceLabs"},glue = "stepDefinitions",
        tags = {"@test"})
public class TestRunner {

}
