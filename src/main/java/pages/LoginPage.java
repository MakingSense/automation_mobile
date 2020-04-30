package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Logger;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Allow Sign in with Fingerprint\"]")
    private MobileElement biometricLabel;

    @AndroidFindBy(xpath = "//android.widget.Switch")
    private MobileElement biometricSwitch;

    AndroidDriver androidDriver;

    public LoginPage(MyDriver aDriver) throws InterruptedException {
        super(aDriver);
        androidDriver = aDriver.getDriver();
        while (!doesElementExist(signInLabel)) {
            Logger.printWarning("The elements have not been initialized yet");
            getWait().until(ExpectedConditions.visibilityOf(signInLabel));
        }
    }

    public void login(String user, String pass) {
        Logger.printDebug("Starting login process");
        Logger.printDebug("Entering the username");
        username.sendKeys(user);
        Logger.printDebug("Entering the password");
        password.sendKeys(pass);

        Logger.printDebug("Clicking on the sign in button");
        signInBtn.get(3).click();
    }

    public String getBiometricMessage() {
        Logger.printDebug("Obtaining the biometric label\'s text");
        return biometricLabel.getText();
    }

    public boolean isBiometricTextPresent() {
        Logger.printDebug("Verifying that the biometric label is present");
        return doesElementExist(biometricLabel);
    }

    public void turnOnBiometricSwitch() {
        Logger.printDebug("Clicking on the biometric switch");
        biometricSwitch.click();
    }

    public String getBiometricSwitchStatus() {
        Logger.printDebug("Verifying biometric switch text");
        return biometricSwitch.getText();
    }
}
