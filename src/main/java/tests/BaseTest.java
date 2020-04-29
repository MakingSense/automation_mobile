package tests;

import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.Logger;
import utils.MyDriver;

import java.net.MalformedURLException;

public abstract class BaseTest {

    private LoginPage loginPage;
    private MyDriver androidDriver;

    {
        try {
            androidDriver = new MyDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {

        Logger.printInfo("Starting the tests set up");

        Logger.printDebug("Instantiating the permissions page");

        loginPage = new LoginPage(androidDriver);
    }

    /*@AfterClass
    public void tearDown() {

        Logger.printInfo("Disposing the driver\'s instance");

        androidDriver.getDriver().quit();

        Logger.printDebug("Driver instance closed");
    }*/

    public LoginPage getLoginPage() {
        Logger.printInfo("Getting a new login page");

        return loginPage;
    }
}