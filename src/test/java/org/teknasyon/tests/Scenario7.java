package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.HomePage;
import org.teknasyon.pages.view.tabs.ScrollablePage;
import org.teknasyon.pages.view.tabs.TabsPage;
import org.teknasyon.pages.view.ViewsPage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario7 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'Views > Tabs menu > 5. Scrollable' menu.
     * 2-Switch to the Tab in the last place.
     * 3-Check that the opened page information belongs to Tab 30.
     */

    private static final Logger logger = Logger.getLogger(Scenario7.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().uninstallApp("com.hmh.api");
        DriverManager.getInstance().installApp("src/main/java/org/teknasyon/utils/apk/API_Demos.apk");
        DriverManager.getInstance().setUpWithClearCache();
    }

    @Test
    public void scenario7() {
        logger.info("Mobile Automation started.");
        logger.info("1-Navigate to the 'Views > Tabs menu > 5. Scrollable' menu.");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickViews();
        ViewsPage viewsPage = new ViewsPage(DriverManager.getInstance().getAppiumDriver());
        viewsPage.scrollDown("Tabs");
        viewsPage.clickTabs();
        TabsPage tabsPage = new TabsPage(DriverManager.getInstance().getAppiumDriver());
        tabsPage.clickScrollable();
        logger.info("Reached the Scrollable Tabs page.");

        logger.info("2-Switch to the Tab in the last place.");
        ScrollablePage scrollablePage = new ScrollablePage(DriverManager.getInstance().getAppiumDriver());
        scrollablePage.scrollRightToLeft("TAB 30");
        scrollablePage.clickTab30();
        logger.info("Switched to the last Tab.");

        logger.info("3-Check that the opened page information belongs to Tab 30.");
        Assert.assertEquals("Opened page information does not belong to Tab 30.",
                "Content for tab with tag Tab 30", scrollablePage.getTextTab());
        logger.info("Page information belongs to Tab 30.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
