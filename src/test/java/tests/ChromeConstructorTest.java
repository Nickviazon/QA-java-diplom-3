package tests;

import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ChromeConstructorTest {
    MainPage mainPage;

    @BeforeClass
    public static void setUpConfigurations() {
        Configuration.browserSize = "1920x1080";
    }

    @Before
    public void openMainPage() {

        mainPage = open(
                "https://stellarburgers.nomoreparties.site/",
                MainPage.class);
    }

    @Test
    public void ingredientsHeadingIsVisible() {
        ElementsCollection ingredientsTransitionPanel = mainPage.getIngredientsTransitionPanel();
        for (int i = ingredientsTransitionPanel.size()-1; i >= 0; i--) {
            SelenideElement ingredientTransition = ingredientsTransitionPanel.get(i);
            ingredientTransition.shouldBe(and("can be clicked", visible, enabled)).click();

            String ingredientName = ingredientTransition.getText();
            assertTrue(mainPage.isIngredientHeadingVisible(ingredientName));
        }
    }
}
