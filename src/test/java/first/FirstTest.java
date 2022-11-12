package first;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeMethod
    public void setUp() {
        open("https://google.com/");
    }

    @Test
    public void search() {
        $x("//input[@name='q']").sendKeys("Google");
        $x("//input[@name='q']").pressEnter();
        $x("//div[@class='g']").shouldHave(Condition.text("Google"));

    }

}
