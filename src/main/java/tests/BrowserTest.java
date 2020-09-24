package tests;

import org.testng.Assert;
import utils.Logger;
import org.testng.annotations.Test;



public class BrowserTest extends BaseTest {

    @Test
    public void browserTest() {
        Logger.printInfo("Executing test browserTest");
        Assert.assertTrue(true);
    }
}
