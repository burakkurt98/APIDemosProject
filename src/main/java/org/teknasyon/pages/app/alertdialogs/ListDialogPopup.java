package org.teknasyon.pages.app.alertdialogs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.alertdialogs.ListDialogPopupConstants;

public class ListDialogPopup extends BasePage {
    /**
     * This page is responsible for handling operations on the list dialog popup.
     * App > Alert Dialogs > List dialog
     */

    @AndroidFindBy(xpath = ListDialogPopupConstants.MESSAGE_TEXT_BOX)
    private MobileElement messageTextBox;
    @AndroidFindBy(xpath = ListDialogPopupConstants.COMMAND_ONE)
    private MobileElement commandOne;

    public ListDialogPopup(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Command one", getTextElementByXPath(commandOne));
    }

    /**
     * Clicks the "Command one" element on the list dialog popup.
     */
    public void clickCommandOne(){
        clickElementByXPath(commandOne);
    }


    /**
     * Checks the message text in the list dialog and verifies the order and name of the selected element.
     * @param expectedOrder The expected order of the selected item.
     * @param expectedName The expected name of the selected item.
     * @return true if the actual order and name match the expected values, false otherwise.
     */
    public boolean checkAlertMessageText(String expectedOrder, String expectedName) {
        String selectedText = getTextElementByXPath(messageTextBox);
        String[] splitText = selectedText.split(",");
        String actualOrder = splitText[0].trim().replace("You selected:", "");
        String actualName = splitText[1].trim();
        boolean isOrderMatched = expectedOrder.equals(actualOrder);
        boolean isNameMatched = expectedName.equals(actualName);
        return isOrderMatched && isNameMatched;
    }
}
