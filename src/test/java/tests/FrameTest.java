package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.sql.Driver;
import java.time.Duration;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", elementAlertsFrameWindows);

        WebElement framesElements = driver.findElement(By.xpath("//span[text()='Frames']"));
        executor.executeScript("arguments[0].click();", framesElements);

        driver.switchTo().frame("frame1");
        //cu alti locators
        // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");
        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement.getText());

        driver.quit();

    }
}
