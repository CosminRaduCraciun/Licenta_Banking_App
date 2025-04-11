package pages;

import config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerTransactionsPage extends DriverManager {

    @FindBy(xpath = "//button[text()='Back']")
    private WebElement backButton;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[text()='>']")
    private WebElement rightArrow;

    @FindBy(xpath = "//button[text()='<']")
    private WebElement leftArrow;

    @FindBy(xpath = "//button[text()='Top']")
    private WebElement topButton;

    @FindBy(xpath = "//*[@id ='anchor0']/td[1]")
    private WebElement firstRowDate;

    @FindBy(xpath = "//*[@id ='anchor0']/td[2]")
    private WebElement firstRowAmount;

    @FindBy(xpath = "//*[@id ='anchor0']/td[3]")
    private WebElement firstRowTransactionType;

    @FindBy(id = "//*[@ng-click = 'home()']")
    private WebElement homeButtonTransactionsPage;

    @FindBy(css = ".btn.logout")
    private WebElement logoutButtonTransactions;

    @FindBy(xpath = "//*[contains(text(),'Date-Time')]")
    private WebElement dateTimeSortingButton;

    public CustomerTransactionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getLeftArrow() {
        return leftArrow;
    }

    public WebElement getRightArrow() {
        return rightArrow;
    }

    public WebElement getFirstRowDate() {
        return firstRowDate;
    }

    public WebElement getFirstRowTransactionType() {
        return firstRowTransactionType;
    }

    public WebElement getTopButton() {
        return topButton;
    }

    public WebElement getHomeButtonTransactionsPage() {
        return homeButtonTransactionsPage;
    }

    public WebElement getFirstRowAmount() {
        return firstRowAmount;
    }

    public WebElement getLogoutButtonTransactions() {
        return logoutButtonTransactions;
    }

    public WebElement getDateTimeSortingButton() {
        return dateTimeSortingButton;
    }


}
