package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement elementAlertsFrameWindows;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement elementForms;

    public void interactWithAlertsFrameWindowMenu() {
        elementHelper.ckickJSElement(elementAlertsFrameWindows);
        LoggerUtility.infoLog("The user clicks on Alert Window Frame Menu");
    }

    public void interactWithElementsMenu() {
        elementHelper.ckickJSElement(elementsMenu);
    }

    public void interactWithFormsMenu() {
        elementHelper.ckickJSElement(elementForms);
    }
}
