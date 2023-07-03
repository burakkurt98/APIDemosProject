package org.teknasyon.pages.view.tabs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.HomePageConstants;
import org.teknasyon.constant.view.tabs.TabsPageConstants;

public class TabsPage extends BasePage {
    /**
     * This page is responsible for handling operations on the tabs page.
     * Views > Tabs menu
     */

    @AndroidFindBy(xpath = TabsPageConstants.CONTENT_BY_ID)
    private MobileElement contentById;
    @AndroidFindBy(xpath = TabsPageConstants.SCROLLABLE)
    private MobileElement scrollable;

    public TabsPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("1. Content By Id", getTextElementByXPath(contentById));
        Assert.assertTrue(findElementByXPath(scrollable).isDisplayed());
    }

    /**
     * Clicks the "5. Scrollable" element on the tabs page.
     */
    public void clickScrollable(){
        clickElementByXPath(scrollable);
    }
}
