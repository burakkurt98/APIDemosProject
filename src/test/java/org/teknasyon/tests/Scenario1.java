package org.teknasyon.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.constant.app.actionbar.ActionBarTabsPageConstants;
import org.teknasyon.pages.app.actionbar.ActionBarPage;
import org.teknasyon.pages.app.actionbar.ActionBarTabsPage;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario1 {
    /**
     * TEST CASE:
     * 1-Navigate to 'Go to App > ActionBar > Action Bar Tabs' menu.
     * 2- Ensure that the 'Toggle tab mode' is in a passive state.
     * 3- Add 3 new tabs and verify that 3 tabs have been added.
     * 4- Delete the last added tab using 'Remove last tab' and confirm that the correct tab has been deleted.
     * 5- Use 'Remove all tabs' to delete all tabs and verify that there are no active tabs in the activity.
     */

    private static final Logger logger = Logger.getLogger(Scenario1.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().installApp("src/main/java/org/teknasyon/utils/apk/API_Demos.apk");
        DriverManager.getInstance().setUpWithClearCache();
        assertTrue(DriverManager.getInstance().checkOpenedApp("com.hmh.api"));
    }

    @Test
    public void scenario1()
    {
        logger.info("Mobil Automation started.");
        logger.info("1-Navigate to 'Go to App > ActionBar > Action Bar Tabs' menu.");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickActionBar();
        ActionBarPage actionBarPage = new ActionBarPage(DriverManager.getInstance().getAppiumDriver());
        actionBarPage.clickActionBarTabs();
        logger.info("Reached the ActionBar Tabs page.");

        logger.info("2- Ensure that the 'Toggle tab mode' is in a passive state.");
        ActionBarTabsPage actionBarTabsPage = new ActionBarTabsPage(DriverManager.getInstance().getAppiumDriver());
        actionBarTabsPage.clickToggleTabBtn();
        assertTrue("Element isn't passive", actionBarTabsPage.findElementByXPath(actionBarTabsPage.toggleBarCheck).isEnabled());
        logger.info("Clicked on the 'Toggle tab mode' button and verified that it is in a passive state.");

        logger.info("3- Add 3 new tabs and verify that 3 tabs have been added.");
        actionBarTabsPage.clickAddNewTabBtn(2);
        int tabs = actionBarTabsPage.checkToggleBarCount(ActionBarTabsPageConstants.TOGGLE_BAR_COUNT);
        assertEquals("The number of tabs is not equal to 3.", 3, tabs);
        logger.info("Added 3 new tabs and verified their addition.");

        logger.info("4- Delete the last added tab using 'Remove last tab' and confirm that " +
                "the correct tab has been deleted.");
        actionBarTabsPage.clickRemoveLastTabs();
        tabs = actionBarTabsPage.checkToggleBarCount(ActionBarTabsPageConstants.TOGGLE_BAR_COUNT);
        assertEquals("The number of tabs is not equal to 2", 2, tabs);
        logger.info("Deleted the last added tab and verified its removal.");

        logger.info("5- Use 'Remove all tabs' to delete all tabs and verify that there are no active tabs in the activity.");
        actionBarTabsPage.clickRemoveAllTabsBtn();
        assertTrue(actionBarTabsPage.findElementByXPath(actionBarTabsPage.toggleBarCheck).isEnabled());
        logger.info("Deleted all tabs and verified their removal.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
