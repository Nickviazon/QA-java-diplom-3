package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @FindBy(how = How.XPATH, using = ".//div[span[contains(@class, 'text')]]")
    private ElementsCollection ingredientsTransitionPanel;

    // Кнопка входа
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти')]")
    private SelenideElement enterAccountButton;

    // Кнопка оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement createOrderButton;


    public ElementsCollection getIngredientsTransitionPanel() {
        return ingredientsTransitionPanel;
    }

    public void clickToTransitionPanelElement(SelenideElement transitionPanelElement) {
        transitionPanelElement.click();
    }

    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isIngredientHeadingVisible(String ingredientName) {
        return $(byXpath(String.format(".//h2[text()='%s']", ingredientName))).isDisplayed();
    }

    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }
}
