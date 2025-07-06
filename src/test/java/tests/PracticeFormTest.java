package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement elementForms = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.ckickJSElement(elementForms);

        WebElement elementPracticeForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.ckickJSElement(elementPracticeForm);

        // wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Adina";
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Anghel";
        elementHelper.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0761231452";
        elementHelper.fillElement(mobileElement, mobileValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
       /* String subjectsValue = "Accounting";
        subjectsElement.sendKeys(subjectsValue);
        subjectsElement.sendKeys(Keys.ENTER); */
        /*String subjectsValue2 = "Ar";
        subjectsElement.sendKeys(subjectsValue2);
        subjectsElement.sendKeys(Keys.ENTER);*/

        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillElement(subjectsElement, subjectsValue.get(index));
            elementHelper.pressElement(subjectsElement, Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class = 'custom-control-label']"));
        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        // facem scroll in jos
        //val pozitive merge in jos
        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }


        //upload picture
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        //ii dam path relativ -> path-ul din acest proiect
        String uploadValue = "src/test/resources/turn.jpg";
        //daca nu merge cu relativ path, extragem absolut path=>
        File file = new File(uploadValue);
        String absolutePath = file.getAbsolutePath();
        elementHelper.fillElement(uploadElement, absolutePath);

        // address
        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str Narciselor, bl B, Sc C";
        elementHelper.fillElement(currentAddressElement, currentAddressValue);

        //de verificat aici excecuteScript
        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Haryana";
        elementHelper.fillElement(stateInputElement, stateValue);
        elementHelper.pressElement(stateInputElement, Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Karnal";
        elementHelper.fillElement(cityElement, cityValue);
        elementHelper.pressElement(cityElement, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        // Wait Explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue), "First Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student Email is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender is not displayed right in the table");

    }

}
