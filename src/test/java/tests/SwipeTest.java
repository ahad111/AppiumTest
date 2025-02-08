package tests;

import base.SetupManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.Swipe_Locators;
import utils.ActionUtil;
import utils.ConfigReaderUtil;

/**
 * Test class for swipe functionality in the application.
 * Extends SetupManager to inherit the setup configuration.
 */
public class SwipeTest extends SetupManager {

    // / Declare variables for form locators, driver, and mobile action utilities
    private Swipe_Locators Swipe;


    private AppiumDriver driver;

    private ActionUtil mobileActions;

    // Test data fetched from configuration file
    private final String TargetText = ConfigReaderUtil.getProperty("TargetText");

    // Setup method to initialize the test environment before the test class execution
    @BeforeClass
    public void setUp() {
        setup();
        this.mobileActions = new ActionUtil(appiumDriver);
        this.Swipe = new Swipe_Locators();
    }

    //This method ensures that the swipe navigation tab is accessible.

    @Test(priority = 9)
    public void clickSwipeNavTab() {
        mobileActions.clickButton(Swipe.Swipe_Nav);
    }

    //   Test case to perform swipe action until the desired text is visible.

    @Test(priority = 10)
    public void swipeToVideo() {
        mobileActions.swipeUntilTextIsVisible(TargetText, Swipe.Textview);
    }
}
