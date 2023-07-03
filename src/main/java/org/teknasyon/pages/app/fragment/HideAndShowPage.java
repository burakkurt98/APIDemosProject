package org.teknasyon.pages.app.fragment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.teknasyon.base.BasePage;
import org.junit.Assert;
import org.teknasyon.constant.app.fragment.HideAndShowPageConstants;

public class HideAndShowPage extends BasePage {
    /**
     * This page is responsible for handling operations on the hide and show page.
     * App > Fragment> Hide and Show
     */

    @AndroidFindBy(xpath = HideAndShowPageConstants.FRAGMENT_BTN)
    private MobileElement fragmentBtn;
    @AndroidFindBy(xpath = HideAndShowPageConstants.FRAGMENT_TEXT_BOX)
    private MobileElement fragmentTextBox;
    @AndroidFindBy(xpath = HideAndShowPageConstants.TEXTVIEW_BTN)
    private MobileElement textviewBtn;
    @AndroidFindBy(xpath = HideAndShowPageConstants.TEXTVIEW_TEXT_BOX)
    private MobileElement textviewTextBox;

    public HideAndShowPage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertTrue(findElementByXPath(fragmentBtn).isDisplayed());
        Assert.assertTrue(findElementByXPath(textviewBtn).isDisplayed());
    }

    /**
     * Clicks the "Fragment Button" element on the hide and show page.
     */
    public void clickFragmentBtn(){
        clickElementByXPath(fragmentBtn);
    }

    /**
     * Returns the text of the "Fragment Button" element on the hide and show page.
     * @return The text of the "Fragment Button" element.
     */
    public String getTextFragmentBtn(){
        return getTextElementByXPath(fragmentBtn);
    }

    /**
     * Clicks the "Textview Button" element on the hide and show page.
     */
    public void clickTextviewBtn(){
        clickElementByXPath(textviewBtn);
    }

    /**
     * Returns the text of the "Textview Button" element on the hide and show page.
     * @return The text of the "Textview Button" element.
     */
    public String getTextTextviewBtn(){
        return getTextElementByXPath(textviewBtn);
    }

    /**
     Returns the text value of the "Textview Button" element on the hide and show page.
     @return The text value of the "Textview Button" element.
     */
    public String getTextBoxValue() {
        return getTextElementByXPath(textviewBtn);
    }

    /**
     * Returns the text of the "Textview Button" element on the hide and show page.
     * @return The text of the "Textview Button" element.
     */
    public boolean checkTextviewTextBoxes(){
        return findElementByXPath(textviewTextBox).isSelected();
    }

    /**
     * Checks the state of the "Hide" buttons and the "TextBoxes" elements on the hide and show page.
     * @return true if both the "Hide" button and the "TextBoxes" element are selected, false otherwise.
     */
    public boolean checkHideButtonsAndTextBoxes() {
        boolean isHideButtonSelected = findElementByXPath(fragmentBtn).isDisplayed() &&
                findElementByXPath(textviewBtn).isDisplayed();
        boolean isTextViewButtonSelected = findElementByXPath(fragmentTextBox).isDisplayed() &&
                findElementByXPath(textviewTextBox).isDisplayed();
        return isHideButtonSelected && isTextViewButtonSelected;
    }
}
