package tests;

import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChromePersonalAccountTest {

    UserOperations userOperations;
    Map<String, String> userData;

    @Before
    public void openMainPage() {
        userOperations = new UserOperations();
        userData = userOperations.register();

        LoginPage loginPage = open(
                "https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.setEmailAndPasswordFields(userData.get("email"), userData.get("password"));
        loginPage.clickEnterButton();
    }

    @After
    public void tearDown (){
        userOperations.delete();
        closeWindow();
    }

    @Test
    public void enterToPersonalAccountFromMainPage() {
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = page(Header.class);
        header.clickAccountButton();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        assertTrue(personalAccountPage.isUserFieldsAreVisible());
        assertEquals("Actual name is different from expected",
                userData.get("name"), personalAccountPage.getNameFieldTextValue());
        assertEquals("Actual login is different from expected",
                userData.get("email"), personalAccountPage.getLoginFieldTextValue());
    }

    @Test
    public void enterToPersonalAccountFromOrdersFeedPage() {
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = page(Header.class);
        header.clickOrderFeedButton();

        OrdersFeedPage orderFeedPage = page(OrdersFeedPage.class);
        assertTrue(orderFeedPage.isPageHeadingVisible());
        header.clickAccountButton();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        assertTrue(personalAccountPage.isUserFieldsAreVisible());
        assertEquals("Actual name is different from expected",
                userData.get("name"), personalAccountPage.getNameFieldTextValue());
        assertEquals("Actual login is different from expected",
                userData.get("email"), personalAccountPage.getLoginFieldTextValue());
    }

    @Test
    public void enterToMainPageFromPersonaAccountPageWithConstructorButton() {
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = page(Header.class);
        header.clickAccountButton();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        assertTrue(personalAccountPage.isUserFieldsAreVisible());

        header.clickConstructorButton();

        assertTrue(mainPage.isPageHeadingVisible());
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void enterToMainPageFromPersonaAccountPageWithLogoButton() {
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = page(Header.class);
        header.clickAccountButton();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        assertTrue(personalAccountPage.isUserFieldsAreVisible());

        header.clickLogoButton();

        assertTrue(mainPage.isPageHeadingVisible());
        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void exitCheckFromPersonalAccountPage() {
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = page(Header.class);
        header.clickAccountButton();

        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        assertTrue(personalAccountPage.isUserFieldsAreVisible());
        personalAccountPage.clickTheExitButton();

        LoginPage loginPage = page(LoginPage.class);
        assertTrue(loginPage.isInputFieldsAndEnterButtonVisible());
    }
}
