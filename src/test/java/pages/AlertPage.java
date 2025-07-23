package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void dealAlertOk() {
        elementHelper.clickElement(alertOkButtonElement);
        LoggerUtility.infoLog("The user clicks on Alert OK Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with Alert Ok presence ");
    }

    public void dealAlertTimer() {
        elementHelper.clickElement(alertWaitButtonElement);
        LoggerUtility.infoLog("The user clicks on Alert Timer Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with Alert Ok presence ");
        pageHelper.scrollPage(0, 400);
        LoggerUtility.infoLog("The user scrolls down the page ");
    }

    public void dealAlertCancel() {
        elementHelper.clickElement(alertOkCancelElement);
        LoggerUtility.infoLog("The user clicks on Alert Ok Button");
        alertHelper.dismissAlert();
        LoggerUtility.infoLog("The user cancels the Alert");
    }

    public void dealAlertPrompt(String value) {
        elementHelper.clickElement(alertPromptElement);
        LoggerUtility.infoLog("The user clicks on Alert prompt");
        alertHelper.fillAlert(value);
        LoggerUtility.infoLog("The user fills the Alert with the value: " + value);
    }

}
