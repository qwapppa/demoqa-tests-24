package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckRegistrationComponent {
    private final SelenideElement table = $(".table-responsive");

    public void checkResult(String key, String value) {
        table.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

    public SelenideElement getTableElement() {
        return table;
    }
}
