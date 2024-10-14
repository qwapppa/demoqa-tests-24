package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        //Заполнение текстовых полей

        open("/automation-practice-form");
        $("#firstName").setValue("Daniil");
        $("#lastName").setValue("Mikhalkov");
        $("#userEmail").setValue("qwapppa@mail.ru");

        //Проставление радио-кнопок

        $("label[for='gender-radio-2']").click();
        $("label[for='gender-radio-3']").click();
        $("label[for='gender-radio-1']").click();

        //Заполнение мобильного телефона

        $("#userNumber").setValue("1234567890");

        //Проставление даты рождения

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--012").click();

        //Выбор меток

        $("#subjectsInput").setValue("civics").pressEnter();

        //Заполнение чек-боксов

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();

        //Загрузка файла

        $("#uploadPicture").uploadFromClasspath("purple.jpg");

        //Заполнение адреса

        $("#currentAddress").setValue("Улица Пушкина дом Колотушкина");

        //Выбор штата и города

        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        //Отправка формы

        $("#submit").click();

        //Проверка формы на корректность

        $(".modal-body").shouldHave(text("Daniil Mikhalkov"));
        $(".modal-body").shouldHave(text("qwapppa@mail.ru"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("12 June,2000"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("Civics"));
        $(".modal-body").shouldHave(text("Улица Пушкина дом Колотушкина"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Lucknow"));
        $(".modal-body").shouldHave(text("purple.jpg"));
    }
}