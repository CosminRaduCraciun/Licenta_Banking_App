package pages;


import config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverManager {

    @FindBy(xpath = "//button[text()='Home']")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@ng-click = 'customer()']")
    private WebElement customerLoginButton;

    @FindBy(xpath = "//*[@ng-click = 'manager()']")
    private WebElement bankManagerButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getCustomerLoginButton() {
        return customerLoginButton;
    }

    public WebElement getBankManagerButton() {
        return bankManagerButton;
    }

}
