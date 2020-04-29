package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MyDriver;
import java.util.List;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = \"Username\"]")
    private MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = \"Password\"]")
    private MobileElement password;

    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> signInBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign in\"]")
    private MobileElement signInLabel;

    AndroidDriver androidDriver;

    public LoginPage(MyDriver aDriver) throws InterruptedException {
        super(aDriver);
        androidDriver = aDriver.getDriver();
    }

    public void login (String user, String pass) {

        getWait().until(ExpectedConditions.visibilityOf(signInLabel));

        username.sendKeys(user);
        password.sendKeys(pass);

        signInBtn.get(3).click();
    }
}
