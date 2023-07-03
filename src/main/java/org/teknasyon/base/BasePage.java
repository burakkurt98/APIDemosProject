package org.teknasyon.base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.teknasyon.utils.DriverManager;

import java.util.Collections;
import java.util.List;

public class BasePage {

    private final WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getAppiumDriver(), 30);

    /**
     * Clicks the element identified by the provided id.
     *
     * @param key The id of the element to be clicked.
     */
    public void clickElementById(String key) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key))).click();
    }

    /**
     * Enters the provided text into the element identified by the provided id.
     *
     * @param key     The id of the element to send the text.
     * @param keyword The text to be sent.
     */
    public void sendKeyElementById(String key, String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key))).sendKeys(keyword);
    }

    /**
     * Clicks the element identified by the provided XPath.
     *
     * @param element The XPath of the element to be clicked.
     */
    public void clickElementByXPath(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element with XPath: " + element + " could not be found.");
        }
    }

    /**
     * Enters the provided text into the element identified by the provided XPath.
     * @param element     The XPath of the element to send the text.
     * @param keyword The text to be sent.
     */
    public void sendKeysElementByXPath(MobileElement element, String keyword) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            element.clear();
            element.sendKeys(keyword);
        } catch (NoSuchElementException e) {
            System.out.println("Element with XPath: " + element + " could not be found.");
        }
    }

    /**
     * Returns the text of the element identified by the provided XPath.
     *
     * @param element The XPath of the element to get the text from.
     * @return The text of the element.
     */
    public String getTextElementByXPath(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (NoSuchElementException e) {
            System.out.println("Element with XPath: " + element + " could not be found.");
            return null;
        }
    }

    /**
     * Finds and returns the element identified by the provided XPath.
     *
     * @param element The XPath to locate the element.
     * @return The element found by the XPath.
     */
    public MobileElement findElementByXPath(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("Element with XPath: " + element + " could not be found.");
        }
        return null;
    }

    /**
     * Finds and returns a list of elements identified by the provided XPath.
     *
     * @param element The WebDriver instance to use for locating the elements.
     * @return The list of MobileElements found by the XPath.
     */
    public List<WebElement> findElementsByXPath(String element) {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
        } catch (NoSuchElementException e) {
            System.out.println("Elements with XPath: " + element + " could not be found.");
            return Collections.emptyList();
        }
    }


    /**
     * Performs a long press action on the element specified by the given XPath
     * for the specified duration in milliseconds.
     *
     * @param element              The XPath of the element to be long-pressed.
     * @param durationInMillis   The duration of the long press action in milliseconds.
     */
    public void longPressElementByXPath(MobileElement element, int durationInMillis) {
        findElementByXPath(element);
        Actions action = new Actions(DriverManager.getInstance().getAppiumDriver());
        action.clickAndHold(element).pause(durationInMillis).release().perform();
    }

    /**
     * Scrolls down to the element with the provided text.
     *
     * @param targetText The text of the element to scroll to.
     */
    public void scrollDown(String targetText) {
        DriverManager.getInstance().getAppiumDriver().findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                        "scrollIntoView(new UiSelector().textContains(\"" + targetText + "\"))");
    }

    /**
     * Scrolls from right to left until finding the element with the provided text.
     *
     * @param textToSearch The text of the element to scroll to.
     */
    public void scrollRightToLeft(String textToSearch) {
        DriverManager.getInstance().getAppiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))." +
                "setAsHorizontalList().scrollIntoView(new UiSelector().text(\"" + textToSearch + "\"))"));
    }

    /**
     * Opens the notification bar.
     */
    public void openNotificationBar() {
        DriverManager.getInstance().getAppiumDriver().openNotifications();
    }

    /**
     * Clicks on the notification with the provided XPath.
     *
     * @param element The XPath of the notification to click.
     */
    public void clickNotificationBar(MobileElement element) {
        findElementByXPath(element).click();
    }

    /**
     * Closes the notification bar.
     */
    public void closeNotificationBar() {
        DriverManager.getInstance().getAppiumDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    /**
     * Returns the app name of the notification with the provided XPath.
     *
     * @param element The XPath of the notification to get the app name from.
     * @return The app name of the notification.
     */
    public String getNotificationAppName(MobileElement element) {
        return getTextElementByXPath(element);
    }

    /**
     * Returns the title of the notification with the provided XPath.
     *
     * @param element The XPath of the notification to get the title from.
     * @return The title of the notification.
     */
    public String getNotificationTitle(MobileElement element){
        return getTextElementByXPath(element);
    }

    /**
     * Returns the text of the notification with the provided XPath.
     *
     * @param element The XPath of the notification to get the text from.
     * @return The text of the notification.
     */
    public String getNotificationText(MobileElement element){
        return getTextElementByXPath(element);
    }
}
