package config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;


public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void createDriver() {
        String browser = PropertyReader.getProperty("browser"); // citește din config.properties

        if (browser == null) {
            browser = "chrome"; // fallback
        }

        switch (browser.toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new"); // 'new' is required for Chromium 109+
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");
                driver = new org.openqa.selenium.edge.EdgeDriver(edgeOptions);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if (System.getenv("CI") != null) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                driver = new ChromeDriver(options);
                break;
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
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
