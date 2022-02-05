package tests;


import com.codeborne.selenide.Configuration;
import com.model.User;
import com.model.UserBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ChromeRegisterTest {

    RegisterPage registerPage;

    @Before
    public void openRegisterPage() {
        ChromeOptions options = new ChromeOptions();
        registerPage = open(
                "https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
    }

    @After
    public void closePage (){
        closeWindow();
    }

    @Test
    public void registerIsPossibleWithin6CharactersInPassword() {
        User user = UserBuilder.createRandomUser(6 );

        registerPage.setFields(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForLoadingPage();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void registerIsPossibleWithinMore6CharactersInPassword() {
        User user = UserBuilder.createRandomUser(7 );

        registerPage.setFields(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailAndPasswordFields(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForLoadingPage();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void registerIsImpossibleWithinLess6CharactersInPassword() {
        User user = UserBuilder.createRandomUser(5 );

        registerPage.setFields(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        assertTrue(registerPage.isInputErrorMessageVisible());
    }


}
