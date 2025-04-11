package pages;

import config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCustomerPage extends DriverManager {

    @FindBy(id = "//*[@ng-click = 'home()']")
    private WebElement homeButtonSelectCustomerPage;

    @FindBy(xpath = "//*[@id = 'userSelect']")
    private WebElement dropdown;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public SelectCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeButtonSelectCustomerPage() {
        return homeButtonSelectCustomerPage;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
