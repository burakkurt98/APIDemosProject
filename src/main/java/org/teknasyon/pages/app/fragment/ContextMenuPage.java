package org.teknasyon.pages.app.fragment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.app.fragment.ContextMenuPageConstants;

public class ContextMenuPage extends BasePage {
    /**
     * This page is responsible for handling operations on the context menu page.
     * App > Fragment > Context Menu
     */

    @AndroidFindBy(xpath = ContextMenuPageConstants.MENU_A)
    private MobileElement menuA;
    @AndroidFindBy(xpath = ContextMenuPageConstants.MENU_B)
    private MobileElement menuB;
    @AndroidFindBy(xpath = ContextMenuPageConstants.LONG_PRESS_BTN)
    private MobileElement longPressBtn;
    @AndroidFindBy(xpath = ContextMenuPageConstants.LONG_PRESS_BTN_DESC)
    private MobileElement getLongPressBtnDesc;

    public ContextMenuPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Fragment populating a context menu; long press the button to see.",
                getTextElementByXPath(getLongPressBtnDesc));
        Assert.assertTrue(findElementByXPath(longPressBtn).isDisplayed());
    }

    /**
     * Clicks the "Long Press" element on the context menu page.
     */
    public void clickLongPressBtn(){

        longPressElementByXPath(longPressBtn, 3000);
    }

    /**
     * Checks if the "Menu A" element is selected.
     *
     * @return   True if the "Menu A" element is selected, false otherwise.
     */
    public boolean checkMenuA() {
        return findElementByXPath(menuA).isDisplayed();
    }

    /**
     * Checks if the "Menu B" element is selected.
     *
     * @return   True if the "Menu B" element is selected, false otherwise.
     */
    public boolean checkMenuB() {
        return findElementByXPath(menuB).isDisplayed();
    }
}
