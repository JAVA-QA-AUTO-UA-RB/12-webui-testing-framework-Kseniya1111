package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropSteps {

    private DragAndDropPage dragAndDropPage;

    @Given("I open the Drag and Drop page")
    public void iOpenTheDragAndDropPage() {
        dragAndDropPage = new DragAndDropPage(WebHooks.driver);
        dragAndDropPage.open();
    }

    @When("I drag element A to element B")
    public void iDragElementAToElementB() {
        dragAndDropPage.performDragAndDrop();
    }

    @Then("I should see that elements A and B have swapped places")
    public void iShouldSeeThatElementsAAndBHaveSwappedPlaces() {
        Assert.assertTrue(dragAndDropPage.areElementsSwapped(),
                "Elements A and B did not swap places!");
    }
}
