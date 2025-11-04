package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HorizontalSliderPage;

public class HorizontalSliderSteps {

    private HorizontalSliderPage sliderPage;

    @Given("I open the Horizontal Slider page")
    public void iOpenTheHorizontalSliderPage() {
        sliderPage = new HorizontalSliderPage(WebHooks.driver);
        sliderPage.open();
    }

    @When("I move the slider to a non-zero position")
    public void iMoveTheSliderToANonZeroPosition() {
        sliderPage.moveSliderRight(3.0);
    }

    @Then("I should see that the slider value is updated")
    public void iShouldSeeThatTheSliderValueIsUpdated() {
        double value = sliderPage.getSliderValue();
        Assert.assertTrue(value > 0, "Slider value did not change! Expected > 0 but got " + value);
    }
}
