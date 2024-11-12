package tests;

import org.junit.jupiter.api.Test;

import pages.PracticeFormPage;

public class PracticeFormTest extends TestBase {

    final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successfulFillFormTest() {

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Daniil")
                .setLastName("Mikhalkov")
                .setEmail("qwapppa@mail.ru")
                .setGender("Female")
                .setMobileNumber("1234567890")
                .setDateOfBirth("12", "June", "2000")
                .setSubject("civics")
                .setHobbyCheckbox("Music")
                .setPicture("purple.jpg")
                .setCurrentAddress("Улица Пушкина дом Колотушкина")
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