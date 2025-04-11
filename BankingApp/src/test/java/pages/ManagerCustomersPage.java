package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerCustomersPage {
    public ManagerCustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//td[4]")
    private WebElement accountNumberCell;
    @FindBy(xpath = "//*[@ng-model = 'searchCustomer']")
    private WebElement customerSearchBar;
    @FindBy(xpath = "//*[@ng-click = 'deleteCust(cust)']")
    private WebElement deleteButton;
    @FindBy(xpath = "//tbody//td[1]")
    private WebElement findCustomerNameInList;

    public WebElement getCustomerSearchBar() {
        return customerSearchBar;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getFindCustomerNameInList() {
        return findCustomerNameInList;
    }

    public WebElement getAccountNumberCell() {
        return accountNumberCell;
    }

}
