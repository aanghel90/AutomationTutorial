package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        TabHelper tabHelper = new TabHelper(driver);

        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.ckickJSElement(elementAlertsFrameWindows);

        WebElement elementBrowserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.ckickJSElement(elementBrowserWindows);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);

        tabHelper.switchToSpecificTab(1);
        //inchidem tabul curent
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindowElement);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //din cauza reclamei fortam site-ul sa acceseze un URL specific => dar sa nu facem asta, nu este recomandat
        //driver.navigate().to("https://demoqa.com/browser-windows");

    }

}
