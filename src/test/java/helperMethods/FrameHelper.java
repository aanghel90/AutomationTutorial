package helperMethods;

import org.openqa.selenium.WebDriver;

public class FrameHelper {
    public WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrameByString(String frameName){
        driver.switchTo().frame(frameName);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
