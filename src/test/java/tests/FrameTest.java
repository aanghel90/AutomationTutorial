package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
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
        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);


        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.ckickJSElement(elementAlertsFrameWindows);

        WebElement framesElements = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.ckickJSElement(framesElements);

        //frameHelper.switchToFrameByString("frame1");
        //cu alti locators
        frameHelper.switchToFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(firstBlockElement);

        frameHelper.switchToParentFrame();

        frameHelper.switchToFrameByString("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(secondBlockElement);

    }
}
