package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Added import
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        System.out.println("Driver in Before: " + driver);
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
