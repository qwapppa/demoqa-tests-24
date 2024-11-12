package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName(randomUtils.userFullName)
                .setEmail(randomUtils.userEmail)
                .setCurrentAddress(randomUtils.userStreetAddress)
                .setPermanentAddress(randomUtils.userStreetAddress)
                .submitForm();

        textBoxPage.checkResult(randomUtils.userFullName, randomUtils.userEmail, randomUtils.userStreetAddress, randomUtils.userStreetAddress);
    }
}