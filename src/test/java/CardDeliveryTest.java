import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {

    @BeforeEach
    void SetUp () {


    }

    @Test
    void shouldRegisterDeliveryTest() {
        open ("http://localhost:9999");
        $$("[type=text]").first().setValue("Самара");
        $("span.menu-item__control").click();
        $("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) );
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        $("[placeholder='Дата встречи']").setValue(date);
        $("[name=name]").setValue("Петров Алексей");
        $$("[type='tel']").last().setValue("+79877899999");
        $("span.checkbox__box").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }
}


