package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.app.alertdialogs.AlertDialogsPage;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.pages.app.alertdialogs.ListDialogPopup;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario3 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'App > Alert Dialogs > List dialog' menu.
     * 2-In the opened activity, select any item in the list dialog.
     * 3-After the selection is made, check the order and name of the selected item in the alert message.
     */

    private static final Logger logger = Logger.getLogger(Scenario3.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().setUpWithoutClearCache();
        DriverManager.getInstance().clearAppCache();
    }

    @Test
    public void scenario3()
    {
        logger.info("Mobil Automation started.");
        logger.info("1-Navigate to the 'App > Alert Dialogs > List dialog' menu.");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickAlertDialogs();
        AlertDialogsPage alertDialogsPage = new AlertDialogsPage(DriverManager.getInstance().getAppiumDriver());
        alertDialogsPage.clickListDialog();
        logger.info("Reached the ActionBar Tabs page.");

        logger.info("2-In the opened activity, select any item in the list dialog.");
        ListDialogPopup listDialogPopup = new ListDialogPopup(DriverManager.getInstance().getAppiumDriver());
        listDialogPopup.clickCommandOne();
        logger.info("Command one is selected.");

        logger.info("3-After the selection is made, check the order and name of the selected item in the alert message.");
        Assert.assertTrue("Alert message isn't equal", listDialogPopup.checkAlertMessageText(" 0", "Command one"));
        logger.info("Alert message checked");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
