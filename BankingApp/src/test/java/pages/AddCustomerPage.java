package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@ng-model = 'fName']")
    private WebElement firstName;
    @FindBy(xpath = "//*[@ng-model = 'lName']")
    private WebElement lastName;
    @FindBy(xpath = "//*[@ng-model = 'postCd']")
    private WebElement postCode;
    @FindBy(xpath = "//*[@type = 'submit']")
    private WebElement submitAddCustomer;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getSubmitAddCustomer() {
        return submitAddCustomer;
    }
}
