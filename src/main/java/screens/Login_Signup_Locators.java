package screens;

import org.openqa.selenium.By;

/**
 * This class contains locators for elements on the Login and Signup screens.
 * It provides By selectors to interact with UI elements in automated tests.
 */
public class Login_Signup_Locators {

    // Locator for the Login navigation tab
    public By Login_Nav = By.xpath("//android.widget.TextView[@text='Login']");

    // Locator for the Sign-up tab
    public By SignUp_Tab = By.xpath("//android.widget.TextView[@text='Sign up']");

    // Locator for the email input field in the Sign-up form
    public By Signup_Email_Txt = By.xpath("//android.widget.EditText[@text='Email']");

    // Locator for the password input field in the Sign-up form
    public By Signup_Password_Txt = By.xpath("//android.widget.EditText[@text='Password']");

    // Locator for the confirm password input field in the Sign-up form
    public By Signup_Conf_Password_Txt = By.xpath("//android.widget.EditText[@text='Confirm password']");

    // Locator for the Sign-up button
    public By Signup_Btn = By.xpath("//android.view.ViewGroup[@content-desc='button-SIGN UP']/android.view.ViewGroup");

    // Locator for the pop-up message after Sign-up/Login action
    public By Pop_Up_Msg = By.id("android:id/message");

    // Locator for the 'OK' button in pop-up messages
    public By Oky_Btn = By.id("android:id/button1");

    // Locator for the Login tab
    public By Login_Tab = By.xpath("(//android.widget.TextView[@text='Login'])[1]");

    // Locator for the email input field in the Login form
    public By Login_Email_Txt = By.xpath("//android.widget.EditText[@content-desc='input-email']");

    // Locator for the password input field in the Login form
    public By Login_Password_Txt = By.xpath("//android.widget.EditText[@content-desc='input-password']");

    // Locator for the Login button
    public By Login_Btn = By.xpath("//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup");
}
