package org.teknasyon.pages.app.activity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.activity.ActivityPageConstants;

public class ActivityPage extends BasePage {
    /**
     * This page is responsible for handling operations on the activity page.
     * App > Activity
     */

    @AndroidFindBy(xpath = ActivityPageConstants.ANIMATION)
    private MobileElement animation;
    @AndroidFindBy(xpath = ActivityPageConstants.CUSTOM_TITLE)
    private MobileElement customTitle;
    @AndroidFindBy(xpath = ActivityPageConstants.HELLO_WORLD)
    private MobileElement helloWord;

    public ActivityPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Custom Title", getTextElementByXPath(customTitle));
        Assert.assertEquals("Animation", getTextElementByXPath(animation));
        Assert.assertTrue(findElementByXPath(helloWord).isDisplayed());
    }

    /**
     * Clicks the "Custom Title" element on the action bar page.
     */
    public void clickCustomTitle(){
        clickElementByXPath(customTitle);
    }
}
