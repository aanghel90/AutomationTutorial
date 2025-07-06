package tests;
import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.ckickJSElement(elementsMenu);

        WebElement elementWebTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.ckickJSElement(elementWebTables);

        List<WebElement> tableList =  driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: " + tableSize + " is not correct");


        //identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Adina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Anghel";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "35";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "20000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "QA";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        tableList =  driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize + 1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        // edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.ckickJSElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Adina";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Anghel";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "test@test.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "30";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "20000";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "QA";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);


        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.ckickJSElement(editLine);

        tableList =  driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize + 1);

        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));

        //delete element
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList =  driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);


    }
}
