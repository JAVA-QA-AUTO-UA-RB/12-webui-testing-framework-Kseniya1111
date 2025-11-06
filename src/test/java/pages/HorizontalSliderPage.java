package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final static String PAGE_URL = "https://the-internet.herokuapp.com/horizontal_slider";

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement valueLabel;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public HorizontalSliderPage moveSliderTo(double targetValue) {
        double current = getSliderValue();
        while (Math.abs(current - targetValue) > 0.1) {
            if (current < targetValue) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
            current = getSliderValue();
        }
        return this;
    }

    public double getSliderValue() {
        return Double.parseDouble(valueLabel.getText());
    }
}
