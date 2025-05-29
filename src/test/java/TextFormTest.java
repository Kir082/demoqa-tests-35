import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Kirill");
        $("#lastName").setValue("Filimonov");
        $("#userEmail").setValue("fil@gmail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2025");
        $(".react-datepicker__month-select").selectOption("May");
        $$(".react-datepicker__day").findBy(text("25")).click();
        $("#subjectsInput").setValue("Accounting").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("bird.jpg");
        $("#currentAddress").setValue("ryazan");
        executeJavaScript("arguments[0].scrollIntoView(true);", $("#state"));
        $("#state").click();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();
        $$("table tr").findBy(text("Student Name")).shouldHave(text("Kirill Filimonov"));
        $$("table tr").findBy(text("Student Email")).shouldHave(text("fil@gmail.ru"));
        $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("table tr").findBy(text("Mobile")).shouldHave(text("1234567890"));
        $$("table tr").findBy(text("Date of Birth")).shouldHave(text("25 May,2025"));
        $$("table tr").findBy(text("Subjects")).shouldHave(text("Accounting"));
        $$("table tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("table tr").findBy(text("Picture")).shouldHave(text("bird.jpg"));
        $$("table tr").findBy(text("Address")).shouldHave(text("ryazan"));
        $$("table tr").findBy(text("State and City")).shouldHave(text("Rajasthan Jaipur"));

    }
}
