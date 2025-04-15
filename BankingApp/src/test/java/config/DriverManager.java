package config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Run headless only in CI environments like GitHub Actions
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new"); // or just "--headless"
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        System.out.println("Driver in Before: " + driver);
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
//
//        System.out.println("Driver in Before: " + driver);
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is null!");
        }
    }

    public static WebDriver getDriver() {

        System.out.println("Driver in getDriver: " + driver);
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized! Call initializeDriver() first.");
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static String geturl() {
        return driver.getCurrentUrl();
    }

}
