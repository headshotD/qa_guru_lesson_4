import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkL4 {
    @BeforeAll
    static void configurationBrowser() {
        Configuration.baseUrl = "https://github.com";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void closeChrome() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Загрузка страницы Enterprises с заголовком \"The AI-powered developer platform.\").")
    void checkHeaderOnGitGubEnterprisesTest() {
        open("/home");
        $(".HeaderMenu-nav").find(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $x("//*[@id='hero-section-brand-heading']").shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }

    @Test
    @DisplayName("Проверка dragAndDrop")
    public void dragAndDropTest() {

        SelenideElement columnA = $x("//div[@id='column-a']");
        SelenideElement columnB = $x("//div[@id='column-b']");
        open("https://the-internet.herokuapp.com/drag_and_drop");
        columnA.shouldHave(text("A"));
        columnB.shouldHave(text("B"));
        $(columnA).dragAndDrop((DragAndDropOptions.to(columnB)));
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

    @Test
    @DisplayName("Проверка dragAndDrop c использованием Actions")
    public void dragAndDropWithActionsTest() {
        SelenideElement columnA = $x("//div[@id='column-a']");
        SelenideElement columnB = $x("//div[@id='column-b']");
        open("https://the-internet.herokuapp.com/drag_and_drop");
        columnA.shouldHave(text("A"));
        columnB.shouldHave(text("B"));
        actions().moveToElement(columnA).clickAndHold().moveToElement(columnB).release().perform();
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

}