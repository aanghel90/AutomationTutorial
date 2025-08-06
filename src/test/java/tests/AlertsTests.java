package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class AlertsTests extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE,Suite.ALERTWINDOWFRAME_SUITE})
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
