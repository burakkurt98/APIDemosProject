package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.app.activity.ActivityPage;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.app.activity.CustomTitlePage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario2 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'App > Activity > Custom Title' menu.
     * 2-In the activity that opens, check the default text in the textBox and navigationBar.
     * 3-Modify the left textBox field and verify that the corresponding textBox and navigationBar texts have changed accordingly.
     * 4-Modify the right textBox field and verify that the corresponding textBox and navigationBar texts have changed accordingly.
     */

    private static final Logger logger = Logger.getLogger(Scenario2.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().setUpWithClearCache();
        DriverManager.getInstance().clearAppCache();
    }

    @Test
    public void scenario2()
    {
        logger.info("Mobil Automation started.");
        logger.info("1-Navigate to the 'App > Activity > Custom Title' menu");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickActivity();
        ActivityPage activityPage = new ActivityPage(DriverManager.getInstance().getAppiumDriver());
        activityPage.clickCustomTitle();
        logger.info("Reached the ActionBar Tabs page.");

        logger.info("2-In the activity that opens, check the default text in the textBox and navigationBar.");
        CustomTitlePage customTitlePage = new CustomTitlePage(DriverManager.getInstance().getAppiumDriver());
        Assert.assertEquals("Right Text isn't equal",customTitlePage.getTextFromRightTextBox(),
                customTitlePage.getRightText());
        Assert.assertEquals("Left Text isn't equal",customTitlePage.getTextFromLeftTextBox(),
                customTitlePage.getLeftText());
        logger.info("Default texts in the text box and navigation bar are checked.");

        logger.info("3-Modify the left textBox field and verify that the corresponding textBox and navigationBar texts have changed accordingly.");
        customTitlePage.sendTextToLeftTextBox("LEFT1");
        customTitlePage.clickChangeLeftBtn();
        Assert.assertEquals("Left Text isn't equal",customTitlePage.getTextFromLeftTextBox(),
                customTitlePage.getLeftText());
        logger.info("The text in the left navigation bar has changed and verified.");

        logger.info("4- Delete the last added tab using 'Remove last tab' and confirm that " +
                "the correct tab has been deleted.");
        customTitlePage.sendTextToRightTextBox("RIGHT1");
        customTitlePage.clickChangeRightBtn();
        Assert.assertEquals("Right Text isn't equal",customTitlePage.getTextFromRightTextBox(),
                customTitlePage.getRightText());
        logger.info("The text in the right navigation bar has changed and verified.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
