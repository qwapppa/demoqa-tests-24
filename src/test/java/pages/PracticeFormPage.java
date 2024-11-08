package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckRegistrationComponent;
import pages.components.DateOfBirthComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            textareaCurrentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            buttonSubmit = $("#submit");


    final DateOfBirthComponent dateOfBirthComponent = new DateOfBirthComponent();
    final CheckRegistrationComponent checkRegistrationComponent = new CheckRegistrationComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;

    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);

        return this;

    }

    public PracticeFormPage setGender(String gender) {
        genderRadio.$(byText(gender)).click();

        return this;
    }

    public PracticeFormPage setMobileNumber(String number) {
        userNumberInput.setValue(number);

        return this;

    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        dateOfBirthComponent.setDate(day, month, year);

        return this;

    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressTab();

        return this;
    }

    public PracticeFormPage setHobbyCheckbox(String hobby) {
        hobbyCheckbox.$(byText(hobby)).click();

        return this;
    }

    public PracticeFormPage setPicture(String filepath) {
        uploadPicture.uploadFromClasspath(filepath);

        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        textareaCurrentAddress.setValue(address);

        return this;

    }

    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();

        return this;

    }

    public PracticeFormPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();

        return this;

    }

    public void submitForm() {
        buttonSubmit.click();
    }

    public PracticeFormPage verifyAppearance(String key, String value) {
        checkRegistrationComponent.checkResult(key, value);

        return this;
    }

    public void checkTableNotExist() {
        checkRegistrationComponent.getTableElement().shouldNotBe(visible);
    }

}
