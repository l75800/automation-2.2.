import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {
    @Test
    void shouldRegisterDeliveryTest() {
        open ("http://localhost:9999");
        $$("[type=text]").first().setValue("Самара");
        $("span.menu-item__control").click();
        LocalDate date = LocalDate.now();
        date = date.plusDays(3);
        $("[placeholder='Дата встречи']").setValue(String.valueOf(date));
        $("[name=name]").setValue("Петров Алексей");
        $$("[type='tel']").last().setValue("+79877899999");
        $("span.checkbox__box").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }
}
