package stepDefinition;

import config.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AddCustomerPage;

public class AddCustomerSteps extends DriverManager {
    public AddCustomerPage addCustomerPage = new AddCustomerPage(getDriver());

    @Then("The user gets the alert banner in field First Name {string}")
    public void getAlertFName(String alert) {
        String validationMessage = addCustomerPage.getFirstName().getDomProperty("validationMessage");
        Assertions.assertEquals(validationMessage, alert);
    }

    @Then("The user gets the alert banner in field Last Name {string}")
    public void getAlertLName(String alert) {
        String validationMessage = addCustomerPage.getLastName().getDomProperty("validationMessage");
        Assertions.assertEquals(validationMessage, alert);
    }

    @Then("The user gets the alert banner in field Post Code {string}")
    public void getAlertPostCode(String alert) {
        String validationMessage = addCustomerPage.getPostCode().getDomProperty("validationMessage");
        Assertions.assertEquals(validationMessage, alert);
    }

    @Then("The user gets a pop-up error message {string}")
    public void getErrorMessage(String alert) {
        String errorMessage = getDriver().switchTo().alert().getText();
        Assertions.assertNotEquals(errorMessage, alert, "Alert does contain error message");
    }
}
