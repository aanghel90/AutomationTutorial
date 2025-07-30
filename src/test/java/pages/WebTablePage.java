package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;

    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstNameValue, String lastNameValue, String emailValue, String ageValue,
                            String salaryValue, String departmentValue) {
        elementHelper.validateListSize(tableList, tableSize);
        LoggerUtility.infoLog("The user validates that the table has " + tableSize + " rows");
        clickAddButton();
        LoggerUtility.infoLog("The user clicks on add button");
        fillFirstName(firstNameValue);
        fillLastName(lastNameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        int expectedTableSize = tableSize + 1;

        elementHelper.validateListSize(tableList, tableSize + 1);
        LoggerUtility.infoLog("The user validates that the table has " + expectedTableSize + " rows");
        elementHelper.validateElementContainsText(tableList.get(tableSize), firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);
    }

    public void editNewEntry(int tableSize, String editFirstNameValue, String editLastNameValue, String editEmailValue, String editAgeValue,
                             String editSalaryValue, String editDepartmentValue) {
        clickEditButton();
        fillEditFirstName(editFirstNameValue);
        fillEditLastName(editLastNameValue);
        fillEditEmail(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();


        elementHelper.validateListSize(tableList, tableSize + 1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

    }

    public void deleteNewEntry(int tableSize) {
        clickDeleteButton();
        LoggerUtility.infoLog("The user removes new entry");
        elementHelper.validateListSize(tableList, tableSize);
    }

    public void clickAddButton() {
        elementHelper.clickElement(addElement);
        LoggerUtility.infoLog("The user clicks on Add button");
    }

    public void fillFirstName(String firstNameValue) {
        elementHelper.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user fills first name field with value: " + firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementHelper.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user fills last name field with value: " + lastNameValue);
    }

    public void fillEmail(String emailValue) {
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills email field with value: " + emailValue);
    }

    public void fillAge(String ageValue) {
        elementHelper.fillElement(ageElement, ageValue);
        LoggerUtility.infoLog("The user fills age field with value: " + ageValue);
    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillElement(salaryElement, salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value: " + salaryValue);
    }

    public void fillDepartment(String departmentValue) {
        elementHelper.fillElement(departmentElement, departmentValue);
        LoggerUtility.infoLog("The user fills department field with value: " + departmentValue);
    }

    public void clickSubmit() {
        elementHelper.clickElement(submitElement);
        LoggerUtility.infoLog("The user clicks Submit");
    }

    public void clickEditButton() {
        elementHelper.ckickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks Edit");
    }

    public void fillEditFirstName(String firstNameValue) {
        elementHelper.clearFillElement(editFirstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user updates first name field with value: " + firstNameValue);
    }

    public void fillEditLastName(String lastNameValue) {
        elementHelper.clearFillElement(editLastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user updates last name field with value: " + lastNameValue);
    }

    public void fillEditEmail(String emailValue) {
        elementHelper.clearFillElement(editEmailElement, emailValue);
        LoggerUtility.infoLog("The user updates email field with value: " + emailValue);
    }

    public void fillEditAge(String ageValue) {
        elementHelper.clearFillElement(editAgeElement, ageValue);
        LoggerUtility.infoLog("The user updates age field with value: " + ageValue);
    }

    public void fillEditSalary(String salaryValue) {
        elementHelper.clearFillElement(editSalaryElement, salaryValue);
        LoggerUtility.infoLog("The user updates salary field with value: " + salaryValue);
    }

    public void fillEditDepartment(String departmentValue) {
        elementHelper.clearFillElement(editDepartmentElement, departmentValue);
        LoggerUtility.infoLog("The user updates department field with value: " + departmentValue);
    }

    public void clickDeleteButton() {
        elementHelper.ckickJSElement(deleteElement);
        LoggerUtility.infoLog("The user clicks on Delete button");

    }


}
