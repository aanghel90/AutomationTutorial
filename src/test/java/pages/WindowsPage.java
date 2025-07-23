package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;

    public void dealWithNewTab(){
        elementHelper.clickElement(newTabElement);
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void dealWithNewWindow(){
        elementHelper.ckickJSElement(newWindowElement);
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }



}
