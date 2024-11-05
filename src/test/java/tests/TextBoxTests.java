package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName("Daniil")
                .setEmail("qwapppa@gmail.com")
                .setCurrentAddress("Улица Пушкина дом Колотушкина")
                .setPermanentAddress("Улица Пушкина дом Колотушкина 2")
                .submitForm();

        textBoxPage.checkResult("Daniil", "qwapppa@gmail.com", "Улица Пушкина дом Колотушкина", "Улица Пушкина дом Колотушкина 2");
    }
}