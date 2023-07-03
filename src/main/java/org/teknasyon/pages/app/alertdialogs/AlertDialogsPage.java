package org.teknasyon.pages.app.alertdialogs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.alertdialogs.AlertDialogsPageConstants;

public class AlertDialogsPage extends BasePage {
    /**
     * This page is responsible for handling operations on the alert dialogs page.
     * Follow the App > Alert Dialogs
     */

    @AndroidFindBy(xpath = AlertDialogsPageConstants.LIST_DIALOG_BTN)
    private MobileElement listDialogBtn;

    public AlertDialogsPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("List dialog", getTextElementByXPath(listDialogBtn));
    }

    /**
     * Clicks the "list dialog" element on the alert dialogs page.
     */
    public void clickListDialog(){
        clickElementByXPath(listDialogBtn);
    }
}
