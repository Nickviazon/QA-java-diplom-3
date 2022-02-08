package tests;

import com.codeborne.selenide.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    MainPage mainPage;

    @Before
    public void openMainPage() {

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
    public void closePage (){
        closeWindow();
    }

    @Test
    @DisplayName("Заголовки ингридиентов отображаются в конструкторе заказа")
    public void ingredientsHeadingIsVisible() {
        mainPage.waitForLoadingPage();
        ElementsCollection ingredientsTransitionPanel = mainPage.getIngredientsTransitionPanel();
        for (int i = ingredientsTransitionPanel.size()-1; i >= 0; i--) {
            SelenideElement ingredientTransition = ingredientsTransitionPanel.get(i);
            ingredientTransition.click();

            String ingredientName = ingredientTransition.getText();
            assertTrue(mainPage.isIngredientSelected(ingredientName));
            assertTrue(mainPage.isIngredientHeadingVisible(ingredientName));
        }
    }
}
