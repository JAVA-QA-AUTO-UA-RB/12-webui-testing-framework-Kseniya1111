package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbTestingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/abtest";

    @FindBy(css = "h3")
    private WebElement header;

    public AbTestingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public AbTestingPage open() {
        driver.get(PAGE_URL);
        return this;
    }
    public String getHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText();
    }
}
