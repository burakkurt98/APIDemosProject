package org.teknasyon.pages.app.activity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.activity.CustomTitlePageConstants;

public class CustomTitlePage extends BasePage {
    /**
     * This page is responsible for handling operations on the custom title page.
     * App > Activity > Custom Title
     */

    @AndroidFindBy(xpath = CustomTitlePageConstants.CHANGE_LEFT_BTN)
    private MobileElement changeLeftBtn;
    @AndroidFindBy(xpath = CustomTitlePageConstants.CHANGE_RIGHT_BTN)
    private MobileElement changeRightBtn;
    @AndroidFindBy(xpath = CustomTitlePageConstants.LEFT_TEXT_BOX)
    private MobileElement leftTextBox;
    @AndroidFindBy(xpath = CustomTitlePageConstants.NAVIGATION_BAR_LEFT_TEXT)
    private MobileElement navigationBarLeftText;
    @AndroidFindBy(xpath = CustomTitlePageConstants.NAVIGATION_BAR_RIGHT_TEXT)
    private MobileElement navigationBarRightText;
    @AndroidFindBy(xpath = CustomTitlePageConstants.RIGHT_TEXT_BOX)
    private MobileElement rightTextBox;

    public CustomTitlePage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertEquals("Right is always right", getTextElementByXPath(navigationBarRightText));
        Assert.assertEquals("Left is best", getTextElementByXPath(navigationBarLeftText));
        Assert.assertTrue(findElementByXPath(changeLeftBtn).isEnabled());
        Assert.assertTrue(findElementByXPath(changeRightBtn).isDisplayed());
    }

    /**
     * Returns the text from the left text box in the navigation bar.
     * @return The text from the left text box.
     */
    public String getLeftText(){
        return getTextElementByXPath(navigationBarLeftText);
    }

    /**
     * Returns the text from the right text box in the navigation bar.
     * @return The text from the right text box.
     */
    public String getRightText(){
        return getTextElementByXPath(navigationBarRightText);
    }

    /**
     * Enters the provided text into the left text box on the page.
     * @param text The text to be entered into the left text box.
     */
    public void sendTextToLeftTextBox(String text) {
        sendKeysElementByXPath(leftTextBox, text);
    }

    /**
     * Returns the text from the right text box on the page.
     * @return The text from the right text box.
     */
    public String getTextFromRightTextBox() {
        return getTextElementByXPath(rightTextBox);
    }

    /**
     * Returns the text from the left text box on the page.
     * @return The text from the left text box.
     */
    public String getTextFromLeftTextBox() {
        return getTextElementByXPath(leftTextBox);
    }

    /**
     * Enters the provided text into the right text box on the page.
     * @param text The text to be entered into the right text box.
     */
    public void sendTextToRightTextBox(String text) {
        sendKeysElementByXPath(rightTextBox, text);
    }

    /**
     * Clicks the "Change Left" button on the page.
     */
    public void clickChangeLeftBtn(){
        clickElementByXPath(changeLeftBtn);
    }

    /**
     * Clicks the "Change Right" button on the page.
     */
    public void clickChangeRightBtn(){
        clickElementByXPath(changeRightBtn);
    }
}

