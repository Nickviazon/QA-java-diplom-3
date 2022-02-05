package tests;

import com.UserOperations;
import org.junit.Before;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class YaEnterTest extends ChromeEnterTest {

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");

        mainPage = open(
                "https://stellarburgers.nomoreparties.site/",
                MainPage.class);
    }
}
