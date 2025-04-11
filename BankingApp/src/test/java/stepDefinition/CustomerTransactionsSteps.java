package stepDefinition;

import config.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CustomerLoginPage;
import pages.CustomerTransactionsPage;


import java.time.Duration;

public class CustomerTransactionsSteps extends DriverManager {
    private int initialBalance;
    private int depositAmount;
    private int withdrawAmount;

    public CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
    public CustomerTransactionsPage customerTransactionsPage = new CustomerTransactionsPage(getDriver());


    @Given("the user is logged on user account page")
    public void theUserIsLoggedOnUserAccountPage() {
        getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(customerLoginPage.getDepositTab()));
    }

    @When("The user clicks on Deposit tab")
    public void userClicksDepositTab() {
        customerLoginPage.getDepositTab().click();
    }

    @And("The user clicks on Deposit button")
    public void userClickDepositButton() {
        customerLoginPage.getDepositButton().click();
    }

    @And("The user checks their current balance")
    public void checkCurrentBalance() {
        String balanceBefore = customerLoginPage.getBalanceDisplay().getText();
        initialBalance = Integer.parseInt(balanceBefore);
    }

    @And("The user enters the amount of money for deposit {string}")
    public void enterDepositAmount(String amount) {
        try {
            depositAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input");
        }

        DriverManager.getWait().until(ExpectedConditions.visibilityOf(customerLoginPage.getAmountField()));
        customerLoginPage.getAmountField().click();
        customerLoginPage.getAmountField().sendKeys(String.valueOf(amount));
    }


    @Then("The deposit success message is displayed")
    public void verifyDepositSuccessMessage() {
        Assertions.assertEquals("Deposit Successful", customerLoginPage.getMessage().getText());
    }

    @Then("The withdraw success message is displayed")
    public void verifyWithdrawSuccessMessage() {
        Assertions.assertEquals("Transaction successful", customerLoginPage.getMessage().getText());
    }

    @Then("Withdraw error message is displayed")
    public void verifyErrorMessage() {
        Assertions.assertEquals("Transaction Failed. You can not withdraw amount more than the balance.",
                customerLoginPage.getMessage().getText());
    }

    @And("The user's balance after deposit is updated correctly")
    public void verifyUpdatedBalanceAfterDeposit() {
        int expectedBalance = initialBalance + depositAmount;
        String actualBalance = customerLoginPage.getBalanceDisplay().getText();
        Assertions.assertEquals(String.valueOf(expectedBalance), actualBalance);
    }

    @And("The user's balance after withdraw is updated correctly")
    public void verifyUpdatedBalanceAfterWithdraw() {
        int expectedBalance = initialBalance - withdrawAmount;
        String actualBalance = customerLoginPage.getBalanceDisplay().getText();
        Assertions.assertEquals(String.valueOf(expectedBalance), actualBalance);
    }

    @When("The user clicks on Withdraw tab")
    public void userClicksWithdrawTab() {
        customerLoginPage.getWithdrawlTab().click();
    }

    @And("The user clicks on Withdraw button")
    public void userClickWithdrawButton() {
        customerLoginPage.getWithdrawbutton().click();
    }

    @And("The user enters the amount of money for withdraw {string}")
    public void enterWithdrawAmount(String amount) {
        try {
            withdrawAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input");
        }

        DriverManager.getWait().until(ExpectedConditions.visibilityOf(customerLoginPage.getAmountField()));
        customerLoginPage.getAmountField().click();
        customerLoginPage.getAmountField().sendKeys(String.valueOf(amount));
    }

    @When("The user clicks on the Transactions tab")
    public void userClickTransactionsTab() throws InterruptedException {
        Thread.sleep(700);
        customerLoginPage.getTransactionsTab().click();
    }

    @And("The user clicks on the Date-time sorting button")
    public void userClickDateTimeSortingButton() {
        customerTransactionsPage.getDateTimeSortingButton().click();
    }

    @Then("The user checks if the first amount is the same as the one typed before {string}")
    public void verifyAmount(String amount) throws InterruptedException {
        Assertions.assertEquals(amount, customerTransactionsPage.getFirstRowAmount().getText());
    }

    @And("The user checks if the Transaction type is correct {string}")
    public void verifyTransactionType(String transactionType) {
        Assertions.assertEquals(transactionType, customerTransactionsPage.getFirstRowTransactionType().getText());
    }

    @When("The user clicks on the 'Back' button")
    public void userClicksBackButton() {
        customerTransactionsPage.getBackButton().click();
    }

}
