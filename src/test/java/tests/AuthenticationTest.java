package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void userShouldLoginAndLogoutSuccessfully() {
        SecureAreaPage secureArea = new LoginPage(driver)
                .open()
                .login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                secureArea.getSuccessMessage().contains("You logged into a secure area!"),
                "Повідомлення про успішний вхід не знайдено"
        );

        LoginPage loginPage = secureArea.logout();
        Assert.assertTrue(
                loginPage.getLogoutMessage().contains("You logged out of the secure area!"),
                "Повідомлення про вихід не знайдено"
        );
    }
}
