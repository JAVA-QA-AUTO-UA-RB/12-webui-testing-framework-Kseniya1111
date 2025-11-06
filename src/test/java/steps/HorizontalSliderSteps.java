package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HorizontalSliderPage;

public class HorizontalSliderSteps {

    private HorizontalSliderPage sliderPage;
    private double initialValue;
    private double updatedValue;

    @Given("I open the Horizontal Slider page")
    public void iOpenTheHorizontalSliderPage() {
        sliderPage = new HorizontalSliderPage(WebHooks.driver);
        sliderPage.open();
    }

    @When("I move the slider to {double}")
    public void iMoveTheSliderTo(double targetValue) {
        initialValue = sliderPage.getSliderValue();
        sliderPage.moveSliderTo(targetValue);
        updatedValue = sliderPage.getSliderValue();
    }

    @Then("I should see that the slider value is updated")
    public void iShouldSeeThatTheSliderValueIsUpdated() {
        Assert.assertNotEquals(updatedValue, initialValue,
                String.format("Expected slider value to change, but stayed at %.1f", initialValue));
        Assert.assertTrue(updatedValue >= 0 && updatedValue <= 5,
                "Slider value out of expected range (0–5): " + updatedValue);
    }
}
