package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void shouldSwapColumnsAfterDragAndDrop() {
        String textAfter = new DragAndDropPage(driver)
                .open()
                .performDragAndDrop()
                .getTextInColumnA();

        Assert.assertEquals(textAfter, "B", "Елементи не помінялися місцями!");
    }
}
