package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/horizontal_slider";

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement rangeValue;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(slider));
        return this;
    }

    public HorizontalSliderPage moveSliderRight(int steps) {
        for (int i = 0; i < steps; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public String getSliderValue() {
        return rangeValue.getText();
    }
}
