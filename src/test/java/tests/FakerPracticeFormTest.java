package tests;

import org.junit.jupiter.api.Test;


public class FakerPracticeFormTest extends TestBase {

    @Test
    void successfulFillFormTest() {

        practiceFormPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.userEmail)
                .setGender(randomUtils.userGender)
                .setMobileNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.userBirthDay, randomUtils.userBirthMonth, randomUtils.userBirthYear)
                .setSubject(randomUtils.userSubject)
                .setHobbyCheckbox(randomUtils.userHobbies)
                .setPicture(randomUtils.userPicture)
                .setCurrentAddress(randomUtils.userStreetAddress)
                .setState(randomUtils.userState)
                .setCity(randomUtils.userCity)
                .submitForm();

        practiceFormPage
                .verifyAppearance("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .verifyAppearance("Student Email", randomUtils.userEmail)
                .verifyAppearance("Gender", randomUtils.userGender)
                .verifyAppearance("Mobile", randomUtils.userNumber)
                .verifyAppearance("Date of Birth", randomUtils.userBirthDay + " " + randomUtils.userBirthMonth + "," + randomUtils.userBirthYear)
                .verifyAppearance("Subjects", randomUtils.userSubject)
                .verifyAppearance("Hobbies", randomUtils.userHobbies)
                .verifyAppearance("Picture", randomUtils.userPicture)
                .verifyAppearance("Address", randomUtils.userStreetAddress)
                .verifyAppearance("State and City", randomUtils.userState + " " + randomUtils.userCity);
    }

    @Test
    void minimalSymbolsFormTest() {

        practiceFormPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.userEmail)
                .setGender(randomUtils.userGender)
                .setMobileNumber(randomUtils.userNumber)
                .submitForm();
        practiceFormPage
                .verifyAppearance("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .verifyAppearance("Gender", randomUtils.userGender)
                .verifyAppearance("Mobile", randomUtils.userNumber);


    }

    @Test
    void negativeTest() {
        practiceFormPage.openPage()
                .submitForm();

        practiceFormPage.checkTableNotExist();
    }
}