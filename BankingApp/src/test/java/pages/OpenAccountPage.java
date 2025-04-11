package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
    private String account;

    public OpenAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    private WebElement customerDropdownMenu;
    @FindBy(xpath = "//*[@value = '6']")
    private WebElement selectCustomerPosition;
    @FindBy(xpath = "//*[@value = '1']")
    private WebElement selectCustomerFirstPosition;
    @FindBy(id = "currency")
    private WebElement currencyDropDownMenu;
    @FindBy(xpath = "//*[@value = 'Dollar']")
    private WebElement selectCurrencyDollar;
    @FindBy(xpath = "//*[@value = 'Pound']")
    private WebElement selectCurrencyPound;
    @FindBy(xpath = "//*[@value = 'Rupee']")
    private WebElement selectCurrencyRupee;
    @FindBy(xpath = "//*[@type = 'submit']")
    private WebElement submitProcessButton;

    public WebElement getCustomerDropdownMenu() {
        return customerDropdownMenu;
    }

    public WebElement getCurrencyDropDownMenu() {
        return currencyDropDownMenu;
    }

    public WebElement getSelectCustomerPosition() { return selectCustomerPosition; }

    public WebElement getSelectCurrencyDollar() { return selectCurrencyDollar; }

    public WebElement getSelectCurrencyPound() { return selectCurrencyPound; }

    public WebElement getSelectCurrencyRupee() { return selectCurrencyRupee; }


    public void getSelectCurrency(String currency) {
        WebElement dropdown = getCurrencyDropDownMenu();
        Select select = new Select(dropdown);
        select.selectByVisibleText(currency);
    }

    public WebElement getSubmitProcessButton() {
        return submitProcessButton;
    }

    public WebElement getSelectFirstCustomerPossition() {
        return selectCustomerFirstPosition;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String newAccount) {
        this.account = newAccount;
    }

}
