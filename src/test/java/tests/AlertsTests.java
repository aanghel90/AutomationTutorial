package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertsTests extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.ckickJSElement(elementAlertsFrameWindows);

        WebElement alertsElements = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.ckickJSElement(alertsElements);

        WebElement alertOkButtonElement = driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(alertOkButtonElement);

        alertHelper.acceptAlert();
        // .dismiss - cancel

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(alertWaitButtonElement);

        alertHelper.acceptAlert();

        pageHelper.scrollPage(0,400);

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(alertOkCancelElement);

        alertHelper.dismissAlert();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromptElement);

        alertHelper.fillAlert("alandala");

    }
}
