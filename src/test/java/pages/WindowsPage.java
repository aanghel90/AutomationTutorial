package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;

    public void dealWithNewTab() {
        elementHelper.clickElement(newTabElement);
        LoggerUtility.infoLog("The user clicks on New Tab Button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switches on second tab opened");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes current tab");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches to initial tab");
    }

    public void dealWithNewWindow() {
        elementHelper.ckickJSElement(newWindowElement);
        LoggerUtility.infoLog("The user clicks on New Window Button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switches on second window opened");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes windowd");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches on second window opened");
    }


}
