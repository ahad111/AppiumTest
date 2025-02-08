package tests;

import base.SetupManager;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.Login_Signup_Locators;
import utils.ActionUtil;
import utils.ConfigReaderUtil;


public class LoginSignupTest extends SetupManager {

    // / Declare variables for form locators, driver, and mobile action utilities
    private Login_Signup_Locators loginSignupForm;

    private AppiumDriver driver;

    private ActionUtil mobileActions;

    // Read test data values from configuration files
    private final String email = ConfigReaderUtil.getProperty("email");
    private final String password = ConfigReaderUtil.getProperty("password");
    private final String valSignupMsg = ConfigReaderUtil.getProperty("valSignupMsg");
    private final String valLoginMsg = ConfigReaderUtil.getProperty("valLoginMsg");

    // Setup method to initialize the test environment before the test class execution
    @BeforeClass
    public void setUp() {
        setup(); // Calling parent class setup method
        this.mobileActions = new ActionUtil(appiumDriver);
        this.loginSignupForm = new Login_Signup_Locators();
    }


    //  Test case to click on the "Login" navigation tab.

    @Test(priority = 1)
    public void clickLoginNavTab() {
        mobileActions.clickButton(loginSignupForm.Login_Nav);
    }

    /**
     * Test case to verify user signup functionality.
     * Fills in the email, password, and confirmation fields,
     * then submits the form and validates the success message.
     */
    @Test(priority = 2)
    public void userSignup() {

        mobileActions.clickButton(loginSignupForm.SignUp_Tab);

        // Enter user details
        mobileActions.fillField(loginSignupForm.Signup_Email_Txt, email);
        mobileActions.fillField(loginSignupForm.Signup_Password_Txt, password);
        mobileActions.fillField(loginSignupForm.Signup_Conf_Password_Txt, password);

        // Click the Sign-Up button
        mobileActions.clickButton(loginSignupForm.Signup_Btn);;
        String result = mobileActions.getValidText(loginSignupForm.Pop_Up_Msg);
        mobileActions.clickButton(loginSignupForm.Oky_Btn);

        // Validate success message
        Assert.assertEquals(result, valSignupMsg, "Assertion Failed: Sign Up Failed!");

        // Click OK button to dismiss pop-up

    }

    /**
     * Test case to verify user login functionality.
     * Clears any existing text in email and password fields,
     * enters login credentials, submits the form, and validates login success.
     */
    @Test(priority = 3)
    public void userLogin() {
        // Clear any pre-filled text fields
        mobileActions.clearText(loginSignupForm.Login_Email_Txt);
        mobileActions.clearText(loginSignupForm.Login_Password_Txt);

        // Navigate to Login tab
        mobileActions.clickButton(loginSignupForm.Login_Tab);

        // Enter login credentials
        mobileActions.fillField(loginSignupForm.Login_Email_Txt, email);
        mobileActions.fillField(loginSignupForm.Login_Password_Txt, password);

        // Click the Login button
        mobileActions.clickButton(loginSignupForm.Login_Btn);

        String result =mobileActions.getValidText(loginSignupForm.Pop_Up_Msg);

        // Click OK button to dismiss pop-up
        mobileActions.clickButton(loginSignupForm.Oky_Btn);
        // Validate success message
        Assert.assertEquals(result, valLoginMsg, "Assertion Failed: Login Failed!");


    }
}

