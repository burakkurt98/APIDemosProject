package org.teknasyon.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.teknasyon.pages.app.AppPage;
import org.teknasyon.pages.HomePage;
import org.teknasyon.pages.app.notification.IncomingMessagePage;
import org.teknasyon.pages.app.notification.NotificationPage;
import org.teknasyon.utils.DriverManager;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class Scenario6 {
    /**
     * TEST CASE:
     * 1-Navigate to the 'App > Notification > Incoming Message' menu.
     * 2-In the opened activity, click the 'Show Notification' button.
     * 3-Open the Notification Bar area and check the notification.
     * 4-Click on the notification and verify that the notification detail opens and the text in the notification bar area contains each other.
     */

    private static final Logger logger = Logger.getLogger(Scenario6.class);

    @Before
    public void setUp() throws MalformedURLException {
        DriverManager.getInstance().setUpWithoutClearCache();
        DriverManager.getInstance().clearAppCache();
    }

    @Test
    public void scenario6() {
        logger.info("Mobile Automation started.");
        logger.info("1-Navigate to the 'App > Notification > Incoming Message' menu.");
        HomePage homePage = new HomePage(DriverManager.getInstance().getAppiumDriver());
        homePage.clickApp();
        AppPage appPage = new AppPage(DriverManager.getInstance().getAppiumDriver());
        appPage.clickNotification();
        NotificationPage notificationPage = new NotificationPage(DriverManager.getInstance().getAppiumDriver());
        notificationPage.clickIncomingMessage();
        logger.info("Reached the Incoming Message page.");

        logger.info("2-Click the 'Show Notification' button.");
        IncomingMessagePage incomingMessagePage = new IncomingMessagePage(DriverManager.getInstance().getAppiumDriver());
        incomingMessagePage.clickShowNotification();
        logger.info("Notification is shown.");

        logger.info("3-Open the Notification Bar area and check the notification.");
        incomingMessagePage.openNotificationBar();
        Assert.assertNotNull("Notification is not displayed.",
                incomingMessagePage.getNotificationAppName(incomingMessagePage.notificationAppName));
        Assert.assertNotNull("Notification title is not displayed.",
                incomingMessagePage.getNotificationTitle(incomingMessagePage.notificationTitle));
        String notificationText = incomingMessagePage.getNotificationText(incomingMessagePage.notificationText);
        Assert.assertNotNull("Notification text is not displayed.", notificationText);
        logger.info("Notification is checked in the Notification Bar area.");

        logger.info("4-Click on the notification and verify that the notification detail opens " +
                "and the text in the notification bar area contain each other.");
        incomingMessagePage.clickNotificationBar(incomingMessagePage.notificationTitle);
        String openNotificationText = incomingMessagePage.getIncomingNotificationText();
        Assert.assertTrue("Notification detail does not match notification text",
                openNotificationText.contains("kthx. meet u for dinner. cul8r"));
        logger.info("Notification detail is opened and the text in the notification bar area contains each other.");
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
