package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Logger;
import utils.MyDriver;

import java.net.MalformedURLException;

public abstract class BaseTest {

    private MyDriver androidDriver;


    {
        try {
            androidDriver = new MyDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sets up the basic tests configuration before a class, it can be changed to test, suite, etc
     * The parameters are defined in the sample.xml file under the suites folder
     * @param page
     */
    @Parameters({ "page" })
    @BeforeClass
    public void setUp(String page) {

        Logger.printInfo("Starting the tests set up");

        androidDriver.getDriver().get(page);
    }

    /**
     * This method clears the memory allocated for the driver.
     */
    @AfterClass
    public void tearDown() {

        Logger.printInfo("Disposing the driver\'s instance");

        androidDriver.getDriver().quit();

        Logger.printDebug("Driver instance closed");
    }

    /**
     * This method you should use as starting point and return the first page of your application
     * It will be commented and you can edit it as you need
     * @return
     */
    /*public Object getLoginPage() {
        Logger.printInfo("Getting a new login page");

        return loginPage;
    }*/
}