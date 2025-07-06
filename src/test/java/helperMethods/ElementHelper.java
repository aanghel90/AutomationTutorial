package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void ckickJSElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void printTextElement(WebElement element){
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys value){
        element.sendKeys(value);
    }
}
