package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void shouldAddAndRemoveElementsCorrectly() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver)
                .open()
                .addElements(3);

        Assert.assertEquals(page.getDeleteButtonsCount(), 3,
                "Очікували, що з’явиться 3 кнопки Delete");
        page.removeAllElements();
        Assert.assertTrue(page.areAllElementsRemoved(),
                "Очікували, що всі кнопки будуть видалені");
    }
}
