package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public abstract class BasePage {

    @FindBy(how = How.CSS, using = "img[alt='loading animation']")
    private SelenideElement loadingImage;

    @Step("Ожидание загрузки страницы")
    public void waitForLoadingPage() {
        loadingImage.shouldBe(not(visible));
    }
}
