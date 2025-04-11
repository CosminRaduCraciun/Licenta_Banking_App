package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 0)
    public void setup() {
        System.out.println("Initializing WebDriver...");
        DriverManager.createDriver();
    }

    @After(order = 0)
    public void tearDown() {
        System.out.println("Closing WebDriver...");
        DriverManager.destroyDriver();
    }
}
