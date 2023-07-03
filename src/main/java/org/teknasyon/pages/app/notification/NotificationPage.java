package org.teknasyon.pages.app.notification;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.app.notification.NotificationPageConstants;

public class NotificationPage extends BasePage {
    /**
     * This page is responsible for handling operations on the notification page.
     * App > Notification
     */

    @AndroidFindBy(xpath = NotificationPageConstants.INCOMING_MESSAGE)
    private MobileElement incomingMessage;
    @AndroidFindBy(xpath = NotificationPageConstants.STATUS_BAR)
    private MobileElement statusBar;

    public NotificationPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("IncomingMessage", getTextElementByXPath(incomingMessage));
        Assert.assertTrue(findElementByXPath(statusBar).isDisplayed());
    }

    /**
     * Clicks the "IncomingMessage" element on the notification page.
     */
    public void clickIncomingMessage(){
        clickElementByXPath(incomingMessage);
    }
}
