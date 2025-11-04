package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationSteps {
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @Given("I open the login page")
    public void iOpenLoginPage() {
        loginPage = new LoginPage(WebHooks.driver);
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithCredentials(String username, String password) {
        secureAreaPage = loginPage.login(username, password);
    }

    @Then("I should see login message {string}")
    public void iShouldSeeSuccessMessage(String expectedMessage) {
        Assert.assertTrue(secureAreaPage.getSuccessMessage().contains(expectedMessage),
                "Success message is not displayed or incorrect");
    }

    @When("I logout")
    public void iLogout() {
        loginPage = secureAreaPage.logout();
    }

    @Then("I should see logout message {string}")
    public void iShouldSeeLogoutMessage(String expectedMessage) {
        Assert.assertTrue(loginPage.getLogoutMessage().contains(expectedMessage),
                "Logout message is not displayed or incorrect");
    }
}
