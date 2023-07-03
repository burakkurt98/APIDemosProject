package org.teknasyon.pages.app.fragment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.fragment.FragmentPageConstants;

public class FragmentPage extends BasePage {
    /**
     * This page is responsible for handling operations on the fragment page.
     * App > Fragment
     */

    @AndroidFindBy(xpath = FragmentPageConstants.ALERT_DIALOG)
    private MobileElement alertDialog;
    @AndroidFindBy(xpath = FragmentPageConstants.ARGUMENTS)
    private MobileElement arguments;
    @AndroidFindBy(xpath = FragmentPageConstants.CONTEXT_MENU)
    private MobileElement contextMenu;
    @AndroidFindBy(xpath = FragmentPageConstants.HIDE_AND_SHOW)
    private MobileElement hideAndShow;

    public FragmentPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Alert Dialog", getTextElementByXPath(alertDialog));
        Assert.assertTrue(findElementByXPath(arguments).isDisplayed());
        Assert.assertTrue(findElementByXPath(contextMenu).isDisplayed());
    }

    /**
     * Clicks the "Context Menu" element on the fragment page.
     */
    public void clickContextMenu(){
        clickElementByXPath(contextMenu);
    }

    /**
     * Clicks the "Hide and Show" element on the fragment page.
     */
    public void clickHideAndShow(){
        clickElementByXPath(hideAndShow);
    }
}
