package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public abstract class BasePage {

    @FindBy(how = How.CSS, using = "img[alt='loading animation']")
    private SelenideElement loadingImage;

    public void waitForLoadingPage() {
        loadingImage.shouldBe(not(visible));
    }
}
