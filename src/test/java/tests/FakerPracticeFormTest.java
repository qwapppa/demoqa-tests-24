// FakerPracticeFormTest

package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import pages.PracticeFormPage;

import java.util.Locale;

public class FakerPracticeFormTest extends TestBase {

    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String streetAddress = faker.address().streetAddress();
    String userNumber = faker.phoneNumber().cellPhone();

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successfulFillFormTest() {

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setMobileNumber(userNumber)
                .setDateOfBirth("12", "June", "2000")
                .setSubjectsInput("civics")
                .setHobbyCheckbox("Music")
                .setPicture("purple.jpg")
                .setCurrentAddress(streetAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        practiceFormPage
                .verifyAppearance("Student Name", "Daniil Mikhalkov")
                .verifyAppearance("Student Email", "qwapppa@mail.ru")
                .verifyAppearance("Gender", "Female")
                .verifyAppearance("Mobile", "1234567890")
                .verifyAppearance("Date of Birth", "12 June,2000")
                .verifyAppearance("Subjects", "Civics")
                .verifyAppearance("Hobbies", "Music")
                .verifyAppearance("Picture", "purple.jpg")
                .verifyAppearance("Address", "Улица Пушкина дом Колотушкина")
                .verifyAppearance("State and City", "NCR Delhi");
    }

    @Test
    void minimalSymbolsFormTest() {

        practiceFormPage.openPage()
                .setFirstName("Daniil")
                .setLastName("Mikhalkov")
                .setGender("Male")
                .setMobileNumber("1234567890")
                .submitForm();
        practiceFormPage
                .verifyAppearance("Student Name", "Daniil Mikhalkov")
                .verifyAppearance("Gender", "Male")
                .verifyAppearance("Mobile", "1234567890");


    }

    @Test
    void negativeTest() {
        practiceFormPage.openPage()
                .submitForm();

        practiceFormPage.checkTableNotExist();
    }
}