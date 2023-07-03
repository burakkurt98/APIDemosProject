package org.teknasyon.pages.app.actionbar;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.actionbar.ActionBarPageConstants;

public class ActionBarPage extends BasePage {
    /**
     * This page is responsible for handling operations on the action bar page.
     * App > ActionBar
     */

    @AndroidFindBy(xpath = ActionBarPageConstants.ACTION_BAR_MECHANICS)
    private MobileElement actionBarMechanics;
    @AndroidFindBy(xpath = ActionBarPageConstants.ACTION_BAR_TABS)
    private MobileElement actionBarTabs;

    public ActionBarPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Action Bar Mechanics", getTextElementByXPath(actionBarMechanics));
        Assert.assertEquals("Action Bar Tabs", getTextElementByXPath(actionBarTabs));
    }

    /**
     * Clicks the "Action Bar Mechanics" element on the action bar page.
     */
    public void clickActionBarMechanics(){
        clickElementByXPath(actionBarMechanics);
    }

    /**
     * Clicks the "Action Bar Tabs" element on the action bar page.
     */
    public void clickActionBarTabs(){
        clickElementByXPath(actionBarTabs);
    }
}

