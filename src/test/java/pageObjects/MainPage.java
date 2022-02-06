package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//div[span[contains(@class, 'text')]]")
    private ElementsCollection ingredientsTransitionPanel;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]")
    private SelenideElement selectedTransitionPanelIngredient;

    // Кнопка входа
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти')]")
    private SelenideElement enterAccountButton;

    // Кнопка оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement createOrderButton;

    // Заголовок страницы
    @FindBy(how = How.XPATH, using = ".//h1[contains(@class,'text')]")
    private SelenideElement pageHeading;

    @Step("Проверка что заголовок главной страницы отображается")
    public boolean isPageHeadingVisible() {
        return pageHeading.shouldBe(and("is visible", exist, visible)).isDisplayed();
    }

    public ElementsCollection getIngredientsTransitionPanel() {
        return ingredientsTransitionPanel;
    }

    @Step("Ингредиент {ingredientName} выбран в панели выбора ингридиентов")
    public boolean isIngredientSelected(String ingredientName) {
       return selectedTransitionPanelIngredient.shouldBe(visible).shouldHave(text(ingredientName)).isDisplayed();
    }

    @Step("Кнопка создания заказа отображается на главной странице")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(visible).isDisplayed();
    }

    @Step("Заголовок {ingredientName} отображается в конструкторе заказов")
    public boolean isIngredientHeadingVisible(String ingredientName) {
        return $(byXpath(String.format(".//h2[text()='%s']", ingredientName))).shouldBe(visible).isDisplayed();
    }

    @Step("Нажата кнопка входа на главной странице")
    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }
}
