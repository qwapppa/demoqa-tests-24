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

        //Радио-кнопка

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

    }
}