package tests;

import org.junit.Before;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class YaRegisterTest extends ChromeRegisterTest {

    @Before
    public void openRegisterPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");

        registerPage = open(
                "https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
    }
}
