package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTests extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(getDriver());
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());

        indexPage.interactWithAlertsFrameWindowMenu();
        alertFrameWindowPage.interactWithAlertsSubmenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("alandala");

    }
}
