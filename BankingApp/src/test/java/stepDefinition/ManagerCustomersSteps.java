package stepDefinition;

import config.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ManagerCustomersPage;

public class ManagerCustomersSteps extends DriverManager {
    ManagerCustomersPage managerCustomersPage = new ManagerCustomersPage(getDriver());

    @When("The user clicks on the delete button")
    public void clickDeleteButton() {
        managerCustomersPage.getDeleteButton().click();
    }

    @Then("The user cannot see the deleted name on the page")
    public void checkPageForName() {
        Assertions.assertFalse(getDriver().getPageSource().contains("Hermoine"));
    }

}
