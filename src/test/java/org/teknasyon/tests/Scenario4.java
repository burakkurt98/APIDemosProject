package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.app.fragment.ContextMenuPage;
import org.teknasyon.pages.app.fragment.FragmentPage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario4 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'App > Fragment > Context Menu' menu
     * 2-In the activity that opens, check if 'Menu A' and 'Menu B' elements are opened by long pressing the 'long press me' button.
     */

    private static final Logger logger = Logger.getLogger(Scenario4.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().setUpWithoutClearCache();
        DriverManager.getInstance().clearAppCache();
    }

    @Test
    public void scenario4()
    {
        logger.info("Mobil Automation started.");
        logger.info("1-Navigate to the 'App > Fragment > Context Menu' menu");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickFragment();
        FragmentPage fragmentPage = new FragmentPage(DriverManager.getInstance().getAppiumDriver());
        fragmentPage.clickContextMenu();
        logger.info("Reached the Context Menu page.");

        logger.info("2-In the activity that opens, check if 'Menu A' and " +
                "'Menu B' elements are opened by long pressing the 'long press me' button.");
        ContextMenuPage contextMenuPage = new ContextMenuPage(DriverManager.getInstance().getAppiumDriver());
        contextMenuPage.clickLongPressBtn();
        Assert.assertTrue("Menu A is not selected.", contextMenuPage.checkMenuA());
        Assert.assertTrue("Menu B is not selected.", contextMenuPage.checkMenuB());
        logger.info("'Menu A' and 'Menu B' are opened by long pressing the 'long press me' button.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
