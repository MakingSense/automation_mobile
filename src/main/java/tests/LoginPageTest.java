package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Logger;

import static utils.ValidationEngineMessages.*;

public class LoginPageTest extends BaseTest {

    private boolean biometricLabel;
    private String bioMessage, switchOff, switchOn;

    @Parameters({"username", "password", "biometricMessage"})
    @Test
    public void loginTest(String username, String password, String biometricMessage) throws InterruptedException {
        Logger.printInfo("Running test");

        LoginPage loginPage = getLoginPage();

        bioMessage = loginPage.getBiometricMessage();
        biometricLabel = loginPage.isBiometricTextPresent();
        switchOff = loginPage.getBiometricSwitchStatus();
        loginPage.turnOnBiometricSwitch();
        switchOn = loginPage.getBiometricSwitchStatus();

        loginPage.login(username, password);

        Assert.assertEquals(bioMessage, biometricMessage, biometricMessageNotCorrect());
        Assert.assertTrue(biometricLabel, biometricLabelIsNotPresent());
        Assert.assertEquals(switchOff, "OFF", biometricSwitchStatusNotCorrect("OFF"));
        Assert.assertEquals(switchOn, "ON", biometricSwitchStatusNotCorrect("ON"));
    }
}
