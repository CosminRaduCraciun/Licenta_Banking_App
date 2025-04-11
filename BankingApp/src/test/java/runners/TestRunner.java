package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition", "config"},
        plugin = {
                "pretty",
                "html:reports/cucumber-reports.html",
                "json:reports/cucumber.json",
                "junit:reports/cucumber.xml"
        },
        monochrome = true
)
public class TestRunner {
}