package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

// Utility class for performing common mobile UI interactions using Appium.

public class ActionUtil {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;


    /**
     * Constructor to initialize the Appium driver and WebDriver wait.
     *
     * @param driver Appium driver instance used for handling mobile elements.
     */
    public ActionUtil(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

    }

    /**
     * Clicks on a button or any clickable element.
     *
     * @param locator The By locator of the element to click.
     */
    public void clickButton(By locator) {
        try {

            MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Fills a text field after ensuring its presence.
     * Clears any existing text before entering the new value.
     *
     * @param locator The By locator of the input field.
     * @param text    The text to be entered into the field.
     */
    public void fillField(By locator, String text) {
        try {

            MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element.clear(); // Clear any existing text in the field
            element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Clicks on a dropdown menu to open it.
     *
     * @param locator The By locator of the dropdown.
     */

    public void selectDropdown(By locator) {
        try {
            MobileElement dropdown = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            dropdown.click();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Selects an option from a dropdown list based on visible text.
     *
     * @param locator    The By locator of the dropdown options.
     * @param optionText The text of the option to be selected.
     */
    public void selectDropdownOption(By locator, String optionText) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

            List<MobileElement> options = driver.findElements(locator);

            // Iterate through options and select "Appium is awesome"
            for (MobileElement option : options) {
                if (option.getText().equals(optionText)) {
                    option.click();
                    return;
                }
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Retrieves the visible text from an element.
     *
     * @param locator The By locator of the element.
     * @return The text of the element.
     */
    public String getValidText(By locator) {

        MobileElement getmessage = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getmessage.getText();
        return getmessage.getText();
    }

    /**
     * Clears text from an input field.
     *
     * @param locator The By locator of the input field.
     */
    public void clearText(By locator) {
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();


    }

    /**
     * Swipes horizontally until a specified text is visible on the screen.
     *
     * @param TargetText The target text to be found.
     * @param locator    The By locator of elements containing the text.
     */
    public void swipeUntilTextIsVisible(String TargetText, By locator) {
        boolean found = false;

        try {
            while (true) {  // Infinite loop until the element is found
                // Find all elements with the same locator
                List<MobileElement> elements = driver.findElements(locator);


                for (MobileElement element : elements) {
                    String texts = element.getText();


                    // Check if the text matches the target text "Support Videos"
                    if (texts.equals(TargetText)) {

                        found = true;
                        return;
                    }


                    // If the text is not found, perform a horizontal swipe
                    if (!found) {

                        swipeHorizontally();
                    }
                }
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Performs a horizontal swipe from right to left.
     * This method is useful for navigating through horizontally scrollable elements.
     */
    private void swipeHorizontally() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);  // Start from right
        int endX = (int) (size.width * 0.2);    // Move left
        double startY = size.height / 1.3;           // Swipe in the middle

        new TouchAction<>(driver).press(PointOption.point(startX, (int) startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))  // Short wait
                .moveTo(PointOption.point(endX, (int) startY)).release().perform();
    }


}