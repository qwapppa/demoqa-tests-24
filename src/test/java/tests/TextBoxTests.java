package tests;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("q");
        $("#userEmail").setValue("qwapppa@pa.com");
        $("#currentAddress").setValue("Street 1");
        $("#permanentAddress").setValue("Street 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("q"));
        $("#output #email").shouldHave(text("qwapppa@pa.com"));
        $("#output #currentAddress").shouldHave(text("Street 1"));
        $("#output #permanentAddress").shouldHave(text("Street 2"));
    }
}
