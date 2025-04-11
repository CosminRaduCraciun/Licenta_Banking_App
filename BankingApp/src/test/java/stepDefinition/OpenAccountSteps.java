package stepDefinition;

import config.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ManagerCustomersPage;
import pages.OpenAccountPage;

public class OpenAccountSteps extends DriverManager {
    OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());
    ManagerCustomersPage managerCustomersPage = new ManagerCustomersPage(getDriver());

    @When("The user selects first customer in list")
    public void selectFirstCustomerInList() {
        openAccountPage.getSelectFirstCustomerPossition().click();
    }


    @When("The user selects the currency {string}")
    public void getselectCurrency(String currency) {
        openAccountPage.getSelectCurrency(currency);
    }

    @When("The user takes the account number from the pop-up banner")
    public String getAccountNumber() {
        String message = getDriver().switchTo().alert().getText();
        openAccountPage.setAccount(message.substring(message.length() - 4));
        return openAccountPage.getAccount();
    }

    @When("The user uses the search bar to find the name {string}")
    public void searchFirstName(String fistname) {
        managerCustomersPage.getCustomerSearchBar().click();
        managerCustomersPage.getCustomerSearchBar().sendKeys(fistname);
    }

    @Then("The new account created is in Account Numbers")
    public void searchAccountNumber() {
        Assertions.assertTrue(managerCustomersPage.getAccountNumberCell().getText().contains("1016"));
    }

    @Then("The user gets an alert on 'Customer Name' field {string}")
    public void getAlertCustomerName(String alert) {
        String validationMessage = openAccountPage.getCustomerDropdownMenu().getDomProperty("validationMessage");
        Assertions.assertEquals(validationMessage, alert);
    }

    @Then("The user gets an alert on 'Currency' field {string}")
    public void getAlertCurrency(String alert) {
        String validationMessage = openAccountPage.getCurrencyDropDownMenu().getDomProperty("validationMessage");
        Assertions.assertEquals(validationMessage, alert);
    }
}
