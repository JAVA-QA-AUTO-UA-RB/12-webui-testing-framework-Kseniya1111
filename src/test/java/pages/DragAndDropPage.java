package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(columnA));
        wait.until(ExpectedConditions.visibilityOf(columnB));
        return this;
    }

    public DragAndDropPage performDragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }
    public boolean areElementsSwapped() {
        String textA = columnA.getText().trim();
        String textB = columnB.getText().trim();
        return textA.equals("B") && textB.equals("A");
    }

    public String getTextInColumnA() {
        return columnA.getText();
    }
}
