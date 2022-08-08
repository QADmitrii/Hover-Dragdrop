import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HoverAndDragDrop {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testHoverTest(){
        open("/");
        $(".HeaderMenu").$(byText("Pricing")).hover();
        $(".HeaderMenu").$(byText("Compare plans")).click();
        webdriver().shouldHave(url("https://github.com/pricing#compare-features"));
        $(".application-main").shouldHave(text("Choose the plan that’s right for you."));
    }

    //Test Drag&Drop
    @Test
    void testDragDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(5000);
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
