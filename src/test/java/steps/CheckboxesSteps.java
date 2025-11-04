package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckboxesPage;

public class CheckboxesSteps {

    private CheckboxesPage checkboxesPage;

    @Given("I open the Checkboxes page")
    public void iOpenTheCheckboxesPage() {
        checkboxesPage = new CheckboxesPage(WebHooks.driver);
        checkboxesPage.open();
    }

    @When("I select all checkboxes")
    public void iSelectAllCheckboxes() {
        checkboxesPage.selectAll();
    }

    @Then("I should see all checkboxes selected")
    public void iShouldSeeAllCheckboxesSelected() {
        Assert.assertTrue(
                checkboxesPage.areAllSelected(),
                "Не всі чекбокси вибрані!"
        );
    }
}
