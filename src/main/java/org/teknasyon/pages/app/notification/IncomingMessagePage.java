package org.teknasyon.pages.app.notification;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.app.notification.IncomingMessagePageConstants;
import org.teknasyon.constant.app.notification.NotificationPageConstants;

public class IncomingMessagePage extends BasePage {
    /**
     * This page is responsible for handling operations on the IncomingMessage page.
     * App > Notification > Incoming Message
     */

    @AndroidFindBy(xpath = IncomingMessagePageConstants.INCOMING_NOTIFICATION_TEXT)
    private MobileElement incomingNotificationText;
    @AndroidFindBy(xpath = IncomingMessagePageConstants.SHOW_NOTIFICATION_BTN)
    private MobileElement showNotificationBtn;
    @AndroidFindBy(xpath = NotificationPageConstants.NOTIFICATION_APP_NAME)
    public MobileElement notificationAppName;
    @AndroidFindBy(xpath = NotificationPageConstants.NOTIFICATION_TITLE)
    public MobileElement notificationTitle;
    @AndroidFindBy(xpath = NotificationPageConstants.NOTIFICATION_TEXT)
    public MobileElement notificationText;

    public IncomingMessagePage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertTrue(findElementByXPath(showNotificationBtn).isDisplayed());
    }

    /**
     * Clicks the "Show Notification" element on the incomingMessage page.
     */
    public void clickShowNotification(){
        clickElementByXPath(showNotificationBtn);
    }

    /**
     * Retrieves the text of the incoming notification on the page.
     * @return the text content of the element representing the incoming notification.
     */
    public String getIncomingNotificationText(){
        return getTextElementByXPath(incomingNotificationText);
    }
}
