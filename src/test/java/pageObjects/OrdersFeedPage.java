package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class OrdersFeedPage {

    // Заголовок страницы
    @FindBy(how = How.XPATH, using = ".//h1[contains(@class,'text')]")
    private SelenideElement pageHeading;

    @Step("Заголовок на странице ленты заказов отображается")
    public boolean isPageHeadingVisible() {
        return pageHeading.shouldBe(and("is visible", exist, visible)).isDisplayed();
    }
}
