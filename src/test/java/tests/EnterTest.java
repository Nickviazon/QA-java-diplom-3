package tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.*;


import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class EnterTest {


    MainPage mainPage;
    UserOperations userOperations;
    Map<String, String> userData;

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

        String browserParameter = System.getProperty("browser");
        if (browserParameter.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        } else if (browserParameter.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        }

        mainPage = open(
                "https://stellarburgers.nomoreparties.site/",
                MainPage.class);
    }

    @After
    public void tearDown (){
        userOperations.delete();
        closeWindow();
    }

    @Test
    @DisplayName("Пользователь может войти из главной страницы")
    public void userCanLoginFromMainPage() {
        mainPage.clickEnterAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Пользователь может войти с помощью кнопки в шапке")
    public void userCanLoginFromHeaderAccountButton() {
        Header header = page(Header.class);
        header.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Пользователь может войти на странице регистрации с помощью ссылки на вход")
    public void userCanLoginFromRegisterPageWithLoginLink() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.clickLoginLink();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Пользователь может выйти на странице восставновления пароля с помощью ссылки на вход")
    public void userCanLoginFromPasswordRecoverPageWithLoginLink() {
        PasswordRecoverPage passwordRecoverPage = open(
                "https://stellarburgers.nomoreparties.site/forgot-password",
                PasswordRecoverPage.class);
        passwordRecoverPage.clickLoginLink();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }
}
