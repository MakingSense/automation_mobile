package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logger;
import utils.MyDriver;

public abstract class BasePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    /**
     * description: This method will relate the page instance and the AndroidDriver instance using the Page factory.
     *              Creates the explicit wait and sets the timeout to 20 seconds.
     * @param aDriver the driver instance
     */
    public BasePage(MyDriver aDriver) throws InterruptedException {
        initPageElements(aDriver);
        driver = aDriver.getDriver();
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * @return the AndroidDriver instance defined in the BasePage constructor.
     */
    public AndroidDriver getDriver() {
        return driver;
    }

    /**
     * @return the wait object defined in the BasePage constructor.
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * description: This method will evaluate if a WebElement exists or not in the page.
     * @param element The WebElement that is evaluated.
     * @return boolean according to existence of WebElement or not
     *
     */
    public Boolean doesElementExist(MobileElement element) {

        try {

            if (element.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            e.getCause();
        }
        return false;
    }

    public void initPageElements(MyDriver driver) {
        Logger.printInfo("Initializing the page elements using PageFactory method \"initElements\"");
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()), this);
    }
}
