package tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.*;


import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class EnterTest extends AbstractBaseTest {


    private MainPage mainPage;
    private UserOperations userOperations;
    private Map<String, String> userData;

    @BeforeClass
    public static void setUpParameters() {
        setBrowserFromParameters();
    }

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

        mainPage = open(baseUrl, MainPage.class);
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
        RegisterPage registerPage = open(baseUrl+registerPath, RegisterPage.class);
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
                baseUrl+forgotPasswordPass,
                PasswordRecoverPage.class);
        passwordRecoverPage.clickLoginLink();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }
}
