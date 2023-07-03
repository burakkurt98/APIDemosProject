package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.app.fragment.FragmentPage;
import org.teknasyon.pages.app.fragment.HideAndShowPage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario5 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'App > Fragment > Hide and Show' menu.
     * 2-Check if there are two Hide buttons and two text boxes in the activity.
     * 3-Click on the second 'Hide' button and verify the changes.
     * 4-Click on the 'Show' button and verify the changes.
     */

    private static final Logger logger = Logger.getLogger(Scenario5.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().setUpWithoutClearCache();
        DriverManager.getInstance().clearAppCache();
    }

    @Test
    public void scenario5()
    {
        logger.info("Mobil Automation started.");
        logger.info("1-Navigate to the 'App > Fragment > Hide and Show' menu.");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickFragment();
        FragmentPage fragmentPage = new FragmentPage(DriverManager.getInstance().getAppiumDriver());
        fragmentPage.clickHideAndShow();
        logger.info("Reached the 'Hide and Show' activity.");

        logger.info("2-Check if there are two Hide buttons and two text boxes in the activity.");
        HideAndShowPage hideAndShowPage = new HideAndShowPage(DriverManager.getInstance().getAppiumDriver());
        Assert.assertTrue("Hide buttons and Text boxes are not active", hideAndShowPage.checkHideButtonsAndTextBoxes());
        logger.info("Verified the presence of two Hide buttons and two text boxes.");

        logger.info("3-Click on the second 'Hide' button and verify the changes.");
        hideAndShowPage.clickTextviewBtn();
        Assert.assertEquals("Text box value is not 'Show' after clicking the Hide button.","Show", hideAndShowPage.getTextBoxValue());
        Assert.assertEquals("Button text is not 'Show' after clicking the Hide button.",
                "Show", hideAndShowPage.getTextTextviewBtn());
        logger.info("Clicked on the second 'Hide' button and verified the changes.");

        logger.info("4-Click on the 'Show' button and verify the changes.");
        hideAndShowPage.clickTextviewBtn();
        Assert.assertNotEquals("Text box value is still 'Hide' after clicking the Show button.","Show", hideAndShowPage.getTextBoxValue());
        Assert.assertEquals("Button text is not 'Hide' after clicking the Show button.",
                "Hide", hideAndShowPage.getTextTextviewBtn());
        logger.info("Clicked on the 'Show' button and verified the changes.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
