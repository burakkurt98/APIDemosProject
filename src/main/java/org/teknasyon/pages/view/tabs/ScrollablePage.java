package org.teknasyon.pages.view.tabs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.teknasyon.constant.view.tabs.ScrollablePageConstants;

public class ScrollablePage extends BasePage {
    /**
     * This page is responsible for handling operations on the scrollable page.
     * Views > Tabs menu > 5. Scrollable
     */

    @AndroidFindBy(xpath = ScrollablePageConstants.TAB1)
    private MobileElement tab1;
    @AndroidFindBy(xpath = ScrollablePageConstants.TAB30)
    private MobileElement tab30;
    @AndroidFindBy(xpath = ScrollablePageConstants.TAB_TEXT)
    private MobileElement tabNext;

    public ScrollablePage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("TAB 1", getTextElementByXPath(tab1));
    }

    /**
     * Clicks the "TAB 30" element on the scrollable page.
     */
    public void clickTab30(){
        clickElementByXPath(tab30);
    }

    /**
     * Retrieves the text from the "TAB" element on the scrollable page.
     *
     * @return The text of the "TAB" element.
     */
    public String getTextTab() {
        return getTextElementByXPath(tabNext);
    }
}
