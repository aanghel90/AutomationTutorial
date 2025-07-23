package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement elementAlertsFrameWindows;
    @FindBy(xpath ="//h5[text()='Elements']" )
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement elementForms;


    public void interactWithAlertsFrameWindowMenu(){
        elementHelper.ckickJSElement(elementAlertsFrameWindows);
    }

    public void interactWithElementsMenu(){ elementHelper.ckickJSElement(elementsMenu);}

    public void interactWithFormsMenu(){ elementHelper.ckickJSElement(elementForms); }
}
