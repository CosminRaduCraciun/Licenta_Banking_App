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

                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "html:target/cucumber-html"

        },
        monochrome = true
)
public class TestRunner {
}