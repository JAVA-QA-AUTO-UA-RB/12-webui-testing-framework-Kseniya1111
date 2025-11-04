package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL="https://the-internet.herokuapp.com/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DropdownPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public DropdownPage selectOption(String optionText) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
        return this;
    }

    public String getSelectedOptionText() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

}
