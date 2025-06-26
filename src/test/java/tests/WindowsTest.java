package tests;

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

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", elementAlertsFrameWindows);

        WebElement elementBrowserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        executor.executeScript("arguments[0].click();", elementBrowserWindows);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();

        System.out.println(driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());


        //inchidem tabul curent
        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());


        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();

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


        //inchidem browserul cu toate taburile
        driver.quit();


    }

}
