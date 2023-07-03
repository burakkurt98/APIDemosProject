package org.teknasyon.pages.view;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.view.ViewsPageConstants;

public class ViewsPage extends BasePage {
    /**
     * This page is responsible for handling operations on the views page.
     */

    @AndroidFindBy(xpath = ViewsPageConstants.ANIMATION)
    private MobileElement animation;
    @AndroidFindBy(xpath = ViewsPageConstants.TABS)
    private MobileElement tabs;

    public ViewsPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Animation", getTextElementByXPath(animation));
    }

    /**
     * Clicks the "Tabs" element on the views page.
     */
    public void clickTabs(){
        clickElementByXPath(tabs);
    }
}
