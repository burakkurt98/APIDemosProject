package org.teknasyon.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.HomePageConstants;

public class HomePage extends BasePage {
    /**
     * This page is responsible for handling operations on the home page.
     */

    @AndroidFindBy(xpath = HomePageConstants.APP)
    private MobileElement app;
    @AndroidFindBy(xpath = HomePageConstants.CONTENT)
    private MobileElement content;
    @AndroidFindBy(xpath = HomePageConstants.NFC)
    private MobileElement nfc;
    @AndroidFindBy(xpath = HomePageConstants.VIEWS)
    private MobileElement views;

    public HomePage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("App", getTextElementByXPath(app));
        Assert.assertEquals("Content", getTextElementByXPath(content));
    }

    /**
     * Clicks the "App" element on the home page.
     */
    public void clickApp(){
        clickElementByXPath(app);
    }

    /**
     * Clicks the "Views" element on the home page.
     */
    public void clickViews(){
        clickElementByXPath(views);
    }
}
