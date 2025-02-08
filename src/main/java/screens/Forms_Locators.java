package screens;

import org.openqa.selenium.By;

/**
 * This class contains locators for elements on the Forms screen.
 * It provides By selectors to interact with UI elements in automated tests.
 */
public class Forms_Locators {

    // Locator for the navigation tab of the Forms screen
    public By Form_Nav = By.xpath("//android.widget.TextView[@text='Forms']");

    // Locator for the input text field
    public By Input_Txt = By.xpath("(//android.widget.EditText[@content-desc='text-input'])[1]");

    // Locator for the label displaying the entered text result
    public By Typed_Lbl = By.xpath("//android.widget.TextView[@content-desc='input-text-result']");

    // Locator for the switch toggle button
    public By Switch_Toggle_Btn = By.xpath("//android.widget.Switch[@content-desc='switch']");

    // Locator for the text result displayed after toggling the switch
    public By Switch_Txt_Res = By.xpath("//android.widget.TextView[@content-desc='switch-text']");

    // Locator for the dropdown field
    public By Dropdown = By.xpath("//android.widget.EditText[@resource-id='text_input']");

    // Locator for dropdown options list
    public By Dropdown_options = By.id("android:id/text1");

    // Locator for the 'Active' button
    public By Active_Btn = By.xpath("//android.widget.TextView[@text='Active']");

    // Locator for the pop-up message
    public By Pop_Up_Msg = By.id("android:id/message");

    // Locator for the 'OK' button on the pop-up message
    public By Oky_Btn = By.id("android:id/button1");
}
