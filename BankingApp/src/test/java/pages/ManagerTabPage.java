package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerTabPage {
    public ManagerTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@ng-class = 'btnClass1']")
    private WebElement addCustomerButton;
    @FindBy(xpath = "//*[@ng-class = 'btnClass2']")
    private WebElement openAccountButton;
    @FindBy(xpath = "//*[@ng-class = 'btnClass3']")
    private WebElement customersButton;

    public WebElement getAddCustomerButton() {
        return addCustomerButton;
    }

    public WebElement getOpenAccountButton() {
        return openAccountButton;
    }

    public WebElement getCustomersButton() {
        return customersButton;
    }
}
