package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Logger;

public class LoginPageTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password) {
        Logger.printInfo("Running test");

        LoginPage loginPage = getLoginPage();

        loginPage.login(username, password);
    }
}
