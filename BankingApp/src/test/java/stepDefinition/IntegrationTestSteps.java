package stepDefinition;

import config.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;


public class IntegrationTestSteps extends DriverManager {
    public HomePage homePage = new HomePage(getDriver());
    public ManagerTabPage managerTabPage = new ManagerTabPage(getDriver());
    public AddCustomerPage addCustomerPage = new AddCustomerPage(getDriver());
    public OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());
    public ManagerCustomersPage managerCustomersPage = new ManagerCustomersPage(getDriver());
    public SelectCustomerPage selectCustomerPage = new SelectCustomerPage(getDriver());
    public CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());


    @Given("The user accesses the main page")
    public void goTo() {
        DriverManager.getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @When("The user clicks on the 'Bank Manager Login' button")
    public void clickBankManagerLoginButton() {
        homePage.getBankManagerButton().click();
    }

    @And("The user clicks on the 'Add Customer' button")
    public void clickAddCustomerButton() {
        managerTabPage.getAddCustomerButton().click();
    }

    @And("The user writes 'first name' {string}")
    public void writeFirstName(String firstname) {
        addCustomerPage.getFirstName().sendKeys(firstname);
    }

    @And("The user writes 'last name' {string}")
    public void writeLastName(String lastname) {
        addCustomerPage.getLastName().sendKeys(lastname);
    }

    @And("The user writes 'post code' {string}")
    public void writePostCode(String postcode) {
        addCustomerPage.getPostCode().sendKeys(postcode);
    }

    @And("The user clicks on submit add customer button")
    public void clickSubmitAddCustomerButton() {
        addCustomerPage.getSubmitAddCustomer().click();
    }

    @And("The user gets the alert banner and clicks ok")
    public void clickOkAlert() {
        getDriver().switchTo().alert().accept();
    }

    @And("The user clicks on 'Open Account' button")
    public void clickOpenAccount() {
        managerTabPage.getOpenAccountButton().click();
    }

    @And("The user clicks on 'Customer Name' dropdown")
    public void clickCustomerNameDropdown() {
        openAccountPage.getCustomerDropdownMenu().click();
    }

    @And("The user clicks on name")
    public void clickCustomerName() {
        openAccountPage.getSelectCustomerPosition().click();
    }

    @And("The user clicks on 'Currency' dropdown")
    public void clickCurrencyDropdown() {
        openAccountPage.getCurrencyDropDownMenu().click();
    }

    @And("The user clicks on 'Process' button")
    public void clickProcessButton() {
        openAccountPage.getSubmitProcessButton().click();
    }

    @And("The user clicks on the Ok button from the alert")
    public void clickOkAlertButton() {
        getDriver().switchTo().alert().accept();
    }

    @And("The user clicks on the 'Customers' button")
    public void clickCustomerButton() {
        managerTabPage.getCustomersButton().click();
    }

    @And("The user searches name {string}")
    public void searchCustomerName(String customerName) {
        managerCustomersPage.getCustomerSearchBar().sendKeys(customerName);
    }

    @Then("The user checks if customer in list")
    public void checkCustomerName() {
        Assertions.assertEquals(managerCustomersPage.getFindCustomerNameInList().getText(), "Cosmin");
    }

    @And("The user clicks on 'Home' button")
    public void clickHomeButton() {
        homePage.getHomeButton().click();
    }

    @And("The user clicks on 'Customer Login' button")
    public void clickCutomerLoginButton() {
        homePage.getCustomerLoginButton().click();
    }

    @And("The user selects the username")
    public void selectUserName() {
        selectCustomerPage.getDropdown().click();
        customerLoginPage.getCustomerUserName().click();
    }

    @And("The user clicks the Login button")
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(selectCustomerPage.getLoginButton()));
        selectCustomerPage.getLoginButton().click();
    }

    @Then("The user gets the message Welcome <name>")
    public void getWelcomeMessage() {
        Assertions.assertEquals(customerLoginPage.getUserName().getText(), "Cosmin Craciun");
    }

}
