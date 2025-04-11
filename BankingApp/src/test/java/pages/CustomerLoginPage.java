package pages;

import config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends DriverManager {

    @FindBy(xpath = "//tbody//td[4]")
    private WebElement accountNumberCell;
    @FindBy(xpath = "//*[@ng-class = 'btnClass2']")
    private WebElement depositTab;
    @FindBy(id = "//*[@ng-click = 'home()']")
    private WebElement homeButtonSelectCustomerPage;
    @FindBy(xpath = "//*[@ng-show='logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@ng-class = 'btnClass3']")
    private WebElement withdrawlTab;
    @FindBy(name = "accountSelect")
    private WebElement accountSelector;
    @FindBy(xpath = "//*[@ng-model = 'amount']")
    private WebElement amountField;
    @FindBy(xpath = "//*[@ng-show = 'message']")
    private WebElement message;
    @FindBy(xpath = "//span[contains(@class, 'fontBig')]")
    private WebElement userName;
    @FindBy(xpath = "//*[@value = '6']")
    private WebElement customerUserName;
    @FindBy(xpath = "//button[text()='Deposit']")
    private WebElement depositButton;
    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement withdrawbutton;
    @FindBy(xpath = "//*[@class='ng-binding'][1]")
    private WebElement accountNumberDisplay;
    @FindBy(xpath = "//*[@class='ng-binding'][2]")
    private WebElement balanceDisplay;
    @FindBy(xpath = "//*[@class='ng-binding'][3]")
    private WebElement currencyDisplay;
    @FindBy(xpath = "//*[@ng-class = 'btnClass1']")
    private WebElement transactionsTab;


    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getDepositTab() {
        return depositTab;
    }

    public WebElement getAmountField() {
        return amountField;
    }

    public WebElement getDepositButton() {
        return depositButton;
    }

    public WebElement getHomeButtonSelectCustomerPage() {
        return homeButtonSelectCustomerPage;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getWithdrawlTab() {
        return withdrawlTab;
    }

    public WebElement getAccountSelector() {
        return accountSelector;
    }

    public WebElement getWithdrawbutton() {
        return withdrawbutton;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getAccountNumberDisplay() {
        return accountNumberDisplay;
    }

    public WebElement getCurrencyDisplay() {
        return currencyDisplay;
    }

    public WebElement getBalanceDisplay() {
        return balanceDisplay;
    }

    public WebElement getTransactionsTab() {
        return transactionsTab;
    }

    public WebElement getCustomerUserName() {
        return customerUserName;
    }


}
