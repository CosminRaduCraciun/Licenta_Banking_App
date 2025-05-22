package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.destroyDriver();
    }

}

