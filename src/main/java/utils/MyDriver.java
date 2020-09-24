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

        /**
         * THE FOLLOWING COMMENTED LINES ARE A SAMPLE IF YOU NEED TO USE AN APPLICATION APK
         */
        // String fileLocation = "ENTER_HERE_THE_PATH_TO_YOUR_APK/*.apk";
        // File originalAppLocation = new File(fileLocation);

        URL connection = new URL("http://0.0.0.0:4723/wd/hub");

        /**
         * This are the capabilities required to run a mobile application
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /**
            To execute the tests in a real android device set the following capability:
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
         */
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_29");
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        capabilities.setCapability("chromedriverExecutable","/Users/Fabian Andres Levin/ideaProjects/automation_mobile/src/main/resources/chromedriver.exe");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        // capabilities.setCapability(MobileCapabilityType.APP, originalAppLocation);
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
