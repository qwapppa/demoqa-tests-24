package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;
import utils.RandomUtils;

public class TestBase {

    final PracticeFormPage practiceFormPage = new PracticeFormPage();
    final RandomUtils randomUtils = new RandomUtils();

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
    }

}
