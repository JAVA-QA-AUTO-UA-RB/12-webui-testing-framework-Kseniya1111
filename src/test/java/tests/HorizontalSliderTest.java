package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void shouldChangeSliderValueWhenMoved() {
        String valueAfter = new HorizontalSliderPage(driver)
                .open()
                .moveSliderRight(3)
                .getSliderValue();

        Assert.assertNotEquals(valueAfter, "0", "Значення слайдера повинно змінитися!");
    }
}
