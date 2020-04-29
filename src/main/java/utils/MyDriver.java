package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyDriver {

    private AndroidDriver<AndroidElement> androidDriver;

    public MyDriver() throws MalformedURLException {

        Logger.printInfo("Setting up the driver instance");

        String fileLocation = "/Users/fabianandreslevin/IdeaProjects/lexis-nexis-mobile-app/src/main/resources/edmonton-qa-formio-renderer.apk";

        URL connection = new URL("http://0.0.0.0:4723/wd/hub");

        File originalAppLocation = new File(fileLocation);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_29");
        capabilities.setCapability(MobileCapabilityType.APP, originalAppLocation);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        Logger.printInfo("All capabilities set and instantiating the driver");

        androidDriver = new AndroidDriver(connection, capabilities);
    }

    public AndroidDriver getDriver() {
        return this.androidDriver;
    }
}
