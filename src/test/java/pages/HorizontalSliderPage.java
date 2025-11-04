package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage {

    private final WebDriver driver;

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement valueLabel;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        return this;
    }


    public HorizontalSliderPage moveSliderRight(double targetValue) {
        Actions actions = new Actions(driver);
        double current = getSliderValue();

        while (current < targetValue) {
            actions.moveToElement(slider).click().sendKeys(Keys.ARROW_RIGHT).perform();
            current = getSliderValue();
        }

        return this;
    }

    public double getSliderValue() {
        return Double.parseDouble(valueLabel.getText());
    }
}
