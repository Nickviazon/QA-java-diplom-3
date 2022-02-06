package tests;

import com.UserOperations;
import org.junit.Before;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class YaPersonalAccountTest extends ChromePersonalAccountTest{

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");

        LoginPage loginPage = open(
                "https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
    }
}
