package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import utils.ConfigReaderUtil;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * SetupManager class initializes and manages the Appium driver setup for mobile automation testing.
 */
public class SetupManager {

    protected static AppiumDriver<MobileElement> appiumDriver;

    /**
     * Sets up the Appium driver with the required capabilities.
     * Initializes the driver only if it is null to avoid redundant instances.
     */
    public void setup() {
        if (appiumDriver == null) {
            try {
                // Fetch APK file path from configuration properties
                String Apk = ConfigReaderUtil.getProperty("apk");
                File apkFile = new File(Apk);

                // Set up desired capabilities for Appium
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

                // Initialize Appium driver with defined capabilities
                appiumDriver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

                // Set implicit wait timeout for driver operations
                appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            }
            catch (Exception e) {
                // Print stack trace if an exception occurs during setup
                e.printStackTrace();
            }
        }
    }

    /**
     * Tears down the Appium driver instance to close the session.
     * Ensures proper cleanup by quitting the driver if it is not null.
     */
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
