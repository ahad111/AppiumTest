package tests;
// Import necessary classes and libraries

import base.SetupManager;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.Forms_Locators;
import utils.ActionUtil;
import utils.ConfigReaderUtil;


public class FormsTest extends SetupManager {

    // Declare variables for form locators, driver, and mobile action utilities
    public Forms_Locators Form;
    public AppiumDriver driver;
    public ActionUtil mobileActions;

    // Read test data values from configuration files
    String Input_Name = ConfigReaderUtil.getProperty("name");
    String Switch_Msg = ConfigReaderUtil.getProperty("valswitchText");
    String Dropdown_Get_Opt = ConfigReaderUtil.getProperty("valDropdown_Get_Option");
    String valActiveMsg = ConfigReaderUtil.getProperty("valActiveMessage");

    // Setup method to initialize the test environment before the test class execution
    @BeforeClass
    public void setUp() {
        setup();
        this.mobileActions = new ActionUtil(appiumDriver);
        this.Form = new Forms_Locators();
    }

    // Test to click the "Login Navigation" tab
    @Test(priority = 4)
    public void ClickLoginNavTab() {
        mobileActions.clickButton(Form.Form_Nav);
    }

    // Test to assert form input field behavior
    @Test(priority = 5)
    public void FormComponentFieldAssertion() {
        mobileActions.fillField(Form.Input_Txt, Input_Name);
        // Validate that the entered text matches the displayed typed label text
        Assert.assertEquals(mobileActions.getValidText(Form.Input_Txt), mobileActions.getValidText(Form.Typed_Lbl), "Assertion Failed: Field and Typed label text are not matched!");
        mobileActions.clickButton(Form.Form_Nav);  // Click on form navigation button
    }

    // Test to validate switch toggle functionality
    @Test(priority = 6)
    public void FormComponentSwitchAssertion() {
        mobileActions.clickButton(Form.Switch_Toggle_Btn);
        // Validate that the displayed switch message matches expected value
        Assert.assertEquals(mobileActions.getValidText(Form.Switch_Txt_Res), Switch_Msg, "Assertion Failed: Result Not Matched!");
    }

    // Test to validate dropdown selection functionality
    @Test(priority = 7)
    public void FormComponentDropdownAssertion() {
        mobileActions.selectDropdown(Form.Dropdown);
        mobileActions.selectDropdownOption(Form.Dropdown_options, Dropdown_Get_Opt);
        // Validate that the selected option is displayed correctly
        Assert.assertEquals(mobileActions.getValidText(Form.Dropdown), Dropdown_Get_Opt, "Assertion Failed: Dropdown option not matched!");
    }

    // Test to validate active button click functionality
    @Test(priority = 8)
    public void FormComponentActiveBtnAssertion() {
        mobileActions.clickButton(Form.Active_Btn);
        String result = mobileActions.getValidText(Form.Pop_Up_Msg);
        mobileActions.clickButton(Form.Oky_Btn);
        Assert.assertEquals(result, valActiveMsg, "Assertion Failed: Button is not active!");

    }
}