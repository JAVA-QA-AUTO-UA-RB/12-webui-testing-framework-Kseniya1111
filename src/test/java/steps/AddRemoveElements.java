package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AddRemoveElementsPage;

public class AddRemoveElements {

    private AddRemoveElementsPage page;

    @Given("I open the AddRemove Elements page")
    public void iOpenTheAddRemoveElementsPage() {
        page = new AddRemoveElementsPage(WebHooks.driver);
        page.open();
    }

    @When("I add {int} {string} buttons")
    public void iAddButtons(int count, String buttonText) {
        page.addElements(count);
    }

    @Then("I should see {int} {string} buttons displayed")
    public void iShouldSeeButtonsDisplayed(int expectedCount, String buttonText) {
        Assert.assertEquals(page.getDeleteButtonsCount(), expectedCount,
                String.format("Expected %d buttons but found %d", expectedCount, page.getDeleteButtonsCount()));
    }

    @When("I remove all {string} buttons")
    public void iRemoveAllButtons(String buttonText) {
        page.removeAllElements();
    }

    @Then("I should see no {string} buttons on the page")
    public void iShouldSeeNoButtons(String buttonText) {
        Assert.assertEquals(page.getDeleteButtonsCount(), 0, "Some 'Delete' buttons are still present!");
    }
}
