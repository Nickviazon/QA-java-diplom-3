package tests;

import org.junit.Before;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class YaConstructorTest extends ChromeConstructorTest {

    @Before
    public void openMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");

        mainPage = open(
                "https://stellarburgers.nomoreparties.site/",
                MainPage.class);
    }
}
