package org.teknasyon.pages.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.AppPageConstants;

public class AppPage extends BasePage {
    /**
     * This page is responsible for handling operations on the app page.
     */

    @AndroidFindBy(xpath = AppPageConstants.ACTION_BAR)
    private MobileElement actionBar;
    @AndroidFindBy(xpath = AppPageConstants.ACTIVITY)
    private MobileElement activity;
    @AndroidFindBy(xpath = AppPageConstants.ALARM)
    private MobileElement alarm;
    @AndroidFindBy(xpath = AppPageConstants.ALERT_DIALOGS)
    private MobileElement alertDialogs;
    @AndroidFindBy(xpath = AppPageConstants.FRAGMENT)
    private MobileElement fragment;
    @AndroidFindBy(xpath = AppPageConstants.NOTIFICATION)
    private MobileElement notification;

    public AppPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Action Bar", getTextElementByXPath(actionBar));
        Assert.assertEquals("Activity", getTextElementByXPath(activity));
        Assert.assertEquals("Alarm", getTextElementByXPath(alarm));
        Assert.assertEquals("Fragment", getTextElementByXPath(fragment));
    }

    /**
     * Clicks the "Activity" element on the app page.
     */
    public void clickActivity(){
        clickElementByXPath(activity);
    }

    /**
     * Clicks the "Action Bar" element on the app page.
     */
    public void clickActionBar(){
        clickElementByXPath(actionBar);
    }

    /**
     * Clicks the "Alert Dialogs" element on the app page.
     */
    public void clickAlertDialogs(){
        clickElementByXPath(alertDialogs);
    }

    /**
     * Clicks the "Fragment" element on the app page.
     */
    public void clickFragment(){
        clickElementByXPath(fragment);
    }

    /**
     * Clicks the "Notification" element on the app page.
     */
    public void clickNotification(){
        clickElementByXPath(notification);
    }
}

