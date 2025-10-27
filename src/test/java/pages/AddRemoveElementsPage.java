package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRemoveElementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String PAGE_URL = "https://the-internet.herokuapp.com/add_remove_elements/";
    private final By addButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.cssSelector("button.added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage open() {
        driver.get(PAGE_URL);
        return this;
    }
    public AddRemoveElementsPage addElements(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(addButton).click();
        }

        wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtons, count));
        return this;
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }

    public AddRemoveElementsPage removeAllElements() {
        while (!driver.findElements(deleteButtons).isEmpty()) {
            driver.findElements(deleteButtons).get(0).click();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(deleteButtons,
                    driver.findElements(deleteButtons).size() + 1));
        }
        return this;
    }

    public boolean areAllElementsRemoved() {
        return driver.findElements(deleteButtons).isEmpty();
    }
}
