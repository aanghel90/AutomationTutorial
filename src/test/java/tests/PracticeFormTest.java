package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormsPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.interactWithPracticeFormsSubmenu();

        String firstNameValue = "Adina";
        String lastNameValue = "Anghel";
        String emailValue = "test@test.com";
        String mobileValue = "0761231452";
        List<String> subjectsValue = Arrays.asList("Arts", "Maths");
        String genderValue = "Female";
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        String uploadValue = "src/test/resources/turn.jpg";
        String currentAddressValue = "Str Narciselor, bl B, Sc C";
        String stateValue = "Haryana";
        String cityValue = "Karnal";

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getDriver());
        practiceFormsPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileValue, subjectsValue, genderValue, hobbyValues, uploadValue, currentAddressValue,
                stateValue, cityValue);
        practiceFormsPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue,
                subjectsValue, hobbyValues, uploadValue, currentAddressValue, stateValue, cityValue );

    }

}
