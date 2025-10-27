package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void allCheckboxesShouldBeSelected() {
        CheckboxesPage page = new CheckboxesPage(driver)
                .open()
                .selectAll();

        Assert.assertTrue(page.areAllSelected(), "Усі чекбокси повинні бути обрані");
    }
}
