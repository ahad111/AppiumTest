package screens;

import org.openqa.selenium.By;

/**
 * This class contains locators for elements on the Swipe screen.
 * It provides By selectors to interact with UI elements in automated tests.
 */
public class Swipe_Locators {

    // Locator for the Swipe navigation tab
    public By Swipe_Nav = By.xpath("//android.widget.TextView[@text='Swipe']");

    // Locator for the text view element within the slide container
    public By Textview = By.xpath("//android.view.ViewGroup[@content-desc='slideTextContainer']/android.widget.TextView[1]");
}
