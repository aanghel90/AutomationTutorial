package tests;

import helperMethods.ElementHelper;
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


        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.ckickJSElement(elementAlertsFrameWindows);

        WebElement elementBrowserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.ckickJSElement(elementBrowserWindows);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);

        System.out.println(driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());


        //inchidem tabul curent
        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());


        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindowElement);

        System.out.println(driver.getCurrentUrl());

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        //inchidem tabul curent
        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());


        //din cauza reclamei fortam site-ul sa acceseze un URL specific => dar sa nu facem asta, nu este recomandat
        //driver.navigate().to("https://demoqa.com/browser-windows");


    }

}
