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
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Anghel";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "35";
        elementHelper.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "20000";
        elementHelper.fillElement(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "QA";
        elementHelper.fillElement(departmentElement,departmentValue);

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
        elementHelper.fillElement(editFirstNameElement,editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Anghel";
        editLastNameElement.clear();
        elementHelper.fillElement(editLastNameElement, editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "test@test.com";
        editEmailElement.clear();
        elementHelper.fillElement(editEmailElement, editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "30";
        editAgeElement.clear();
        elementHelper.fillElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "20000";
        editSalaryElement.clear();
        elementHelper.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "QA";
        editDepartmentElement.clear();
        elementHelper.fillElement(editDepartmentElement, editDepartmentValue);


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
        elementHelper.ckickJSElement(deleteElement);

        tableList =  driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);


    }
}
