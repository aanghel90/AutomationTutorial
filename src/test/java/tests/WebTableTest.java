package tests;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void testMethod(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubMenu();

        int tableSize = 3;
        //identificam un element

        String firstNameValue = "Adina";
        String lastNameValue = "Anghel";
        String emailValue = "test@test.com";
        String ageValue = "35";
        String salaryValue = "20000";
        String departmentValue = "QA";
        String editFirstNameValue = "Adina";
        String editLastNameValue = "Anghel";
        String editEmailValue = "test@test.com";
        String editAgeValue = "30";
        String editSalaryValue = "20000";
        String editDepartmentValue = "QA";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addNewEntry(tableSize, firstNameValue, lastNameValue, emailValue, ageValue,
                salaryValue, departmentValue);
        webTablePage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue,
                editAgeValue, editSalaryValue, editDepartmentValue);

        webTablePage.deleteNewEntry(tableSize);

    }
}
