package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void optionTwoShouldBeSelected() {
        DropdownPage page = new DropdownPage(driver)
                .open()
                .selectOption("2");

        Assert.assertEquals(page.getSelectedOptionText(), "Option 2", "Option 2 повинна бути обрана");
    }
}
