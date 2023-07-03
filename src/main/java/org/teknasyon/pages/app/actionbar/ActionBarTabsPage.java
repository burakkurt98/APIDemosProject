package org.teknasyon.pages.app.actionbar;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.actionbar.ActionBarTabsPageConstants;

import java.util.List;

public class ActionBarTabsPage extends BasePage {
    /**
     * This page is responsible for handling operations on the action bar tabs page.
     * Go to App > ActionBar > Action Bar Tabs'
     */

    @AndroidFindBy(xpath = ActionBarTabsPageConstants.ADD_NEW_TAB_BTN)
    private MobileElement addNewTabBtn;
    @AndroidFindBy(xpath = ActionBarTabsPageConstants.REMOVE_ALL_TABS_BTN)
    private MobileElement removeAllTabsBtn;
    @AndroidFindBy(xpath = ActionBarTabsPageConstants.TOGGLE_TAB_BTN)
    private MobileElement toggleTabBtn;
    @AndroidFindBy(xpath = ActionBarTabsPageConstants.REMOVE_LAST_TAB_BTN)
    private MobileElement removeLastTabBtn;
    @AndroidFindBy(xpath = ActionBarTabsPageConstants.TOGGLE_BAR_CHECK)
    public MobileElement toggleBarCheck;
    @AndroidFindBy(xpath = ActionBarTabsPageConstants.TOGGLE_BAR_COUNT)
    public MobileElement toggleBarCount;

    public ActionBarTabsPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertTrue(findElementByXPath(addNewTabBtn).isDisplayed());
        Assert.assertEquals("Remove all tabs", getTextElementByXPath(removeAllTabsBtn));
        Assert.assertTrue(findElementByXPath(toggleTabBtn).isDisplayed());
        Assert.assertTrue(findElementByXPath(removeLastTabBtn).isDisplayed());
    }

    /**
     * Clicks the "Add New Tab" button on the page for the specified number of times.
     * @param count The number of times to click the button.
     */
    public void clickAddNewTabBtn(int count) {
        for (int i = 0; i <= count; i++) {
            clickElementByXPath(addNewTabBtn);
        }
    }

    /**
     * Clicks the "Remove Last Tab" button on the page.
     */
    public void clickRemoveLastTabs(){
        clickElementByXPath(removeLastTabBtn);
    }

    /**
     * Clicks the "Toggle Tab" button on the page.
     */
    public void clickToggleTabBtn(){
        clickElementByXPath(toggleTabBtn);
    }

    /**
     * Clicks the "Remove All Tabs" button on the page.
     */
    public void clickRemoveAllTabsBtn(){
        clickElementByXPath(removeAllTabsBtn);
    }

    public int checkToggleBarCount(String element) {
        int count = 0;
        List<WebElement> list = findElementsByXPath(element);
        for (WebElement toggleBar : list) {
            if (toggleBar.isEnabled()) {
                count++;
            }
        }
        return count;
    }

}

