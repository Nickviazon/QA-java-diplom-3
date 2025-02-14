package tests;

import com.model.User;
import com.model.UserBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends AbstractBaseTest {

    private RegisterPage registerPage;

    @BeforeClass
    public static void setUpParameters() {
        setBrowserFromParameters();
    }

    @Before
    public void openPage() {
        registerPage = open(
                baseUrl+ registerPath,
                RegisterPage.class);
    }

    @After
    public void closePage (){
        closeWindow();
    }

    @Test
    @DisplayName("Регистрация возможна если 6 знаков в пароле")
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
    @DisplayName("Регистрация возможна если больше 6 знаков в пароле")
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
    @DisplayName("Регистрация не возможна если в пароле меньше 6 знаков")
    @Description("Регистрация не возможна если в пароле меньше 6 знаков. Отображается сообщение об ошибке ввода")
    public void registerIsImpossibleWithinLess6CharactersInPassword() {
        User user = UserBuilder.createRandomUser(5 );

        registerPage.setFields(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        assertTrue(registerPage.isInputErrorMessageVisible());
    }


}
