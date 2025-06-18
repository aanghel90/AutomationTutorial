package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTests {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        WebElement elementAlertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", elementAlertsFrameWindows);

        WebElement alertsElements = driver.findElement(By.xpath("//span[text()='Alerts']"));
        executor.executeScript("arguments[0].click();", alertsElements);

        WebElement alertOkButtonElement = driver.findElement(By.id("alertButton"));
        alertOkButtonElement.click();

        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();
        // .dismiss - cancel

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        alertWaitButtonElement.click();


        //Wait explicit pt Alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait = driver.switchTo().alert();
        alertWait.accept();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        alertOkCancelElement.click();

        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        alertPromptElement.click();


        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("AlabalaPortocala");
        alertPrompt.accept();

        driver.quit();

    }
}
