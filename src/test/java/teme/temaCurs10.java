package teme;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class temaCurs10 {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        // wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Adina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Anghel";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0755555201";
        mobileElement.sendKeys(mobileValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
       /* String subjectsValue = "Accounting";
        subjectsElement.sendKeys(subjectsValue);
        subjectsElement.sendKeys(Keys.ENTER); */
        /*String subjectsValue2 = "Ar";
        subjectsElement.sendKeys(subjectsValue2);
        subjectsElement.sendKeys(Keys.ENTER);*/

        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class = 'custom-control-label']"));
        switch (genderValue) {
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;
        }

        // facem scroll in jos
        //val pozitive merg in jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }


        //upload picture
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        //ii dam path relativ -> path-ul din acest proiect
        String uploadValue = "src/test/resources/turn.jpg";
        //daca nu merge cu relativ path, extragem absolut path=>
        File file = new File(uploadValue);
        String absolutePath = file.getAbsolutePath();
        uploadElement.sendKeys(absolutePath);

        // address
        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str Narciselor, bl B, Sc C";
        currentAddressElement.sendKeys(currentAddressValue);

        //de verificat aici excecuteScript
        WebElement stateElement = driver.findElement(By.id("state"));
        //js.executeScript("arguments[0].click();", stateElement);
        stateElement.click();

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Haryana";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Karnal";
        cityElement.sendKeys(cityValue);
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

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



                            /* --------------------------------------------TEMA curs 10------------------------------------------------------------------------------------------------- */


        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), mobileValue, "Mobile is not displayed right in the table");


        //Assert.assertEquals(tableDescriptionList.get(4).getText(), "Date of Birth", "DOB is not displayed right in the table");
        //Assert.assertEquals(tableValueList.get(4).getText(), dateOfBirth, "Mobile is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(5).getText(), "Subjects", "Subjects column is not displayed right in the table");
        String resultSubjects = String.join(", ", subjectsValue);
        //String res = "Accounting, Arts, Mat";
        //System.out.println(result);
        Assert.assertEquals(tableValueList.get(5).getText(), resultSubjects, "Subjects are not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(6).getText(), "Hobbies", "Subjects column is not displayed right in the table");
        String resultHobbies = String.join(", ", hobbyValues);
        Assert.assertEquals(tableValueList.get(6).getText(), resultHobbies, "Hobbies are not displayed right in the table");


        Assert.assertEquals(tableDescriptionList.get(7).getText(), "Picture", "Picture column is not displayed right in the table");
        String uploadValueName = "turn.jpg";
        Assert.assertEquals(tableValueList.get(7).getText(), uploadValueName, "Picture name is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(8).getText(), "Address", "Address is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(8).getText(), currentAddressValue, "Address is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(9).getText(), "State and City", "State and City is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(stateValue), "State text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(cityValue), "City text is not displayed right in the table");



    }
}
