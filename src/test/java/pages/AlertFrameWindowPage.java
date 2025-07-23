package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElements;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesElements;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement elementBrowserWindows;

    public void interactWithAlertsSubmenu() {
        elementHelper.ckickJSElement(alertsElements);
        LoggerUtility.infoLog("The user clicks on Alerts Submenu");
    }

    public void interactWithFramesSubmenu() {
        elementHelper.ckickJSElement(framesElements);
    }

    public void interactWithWindowsSubmenu() {
        elementHelper.ckickJSElement(elementBrowserWindows);
    }
}
