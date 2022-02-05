package tests;

import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.*;


import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ChromeEnterTest {


    MainPage mainPage;
    UserOperations userOperations;
    Map<String, String> userData;

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

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
    public void userCanLoginFromMainPage() {
        mainPage.clickEnterAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void userCanLoginFromHeaderAccountButton() {
        Header header = page(Header.class);
        header.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void userCanLoginFromRegisterPageWithLoginLink() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.clickLoginLink();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
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
