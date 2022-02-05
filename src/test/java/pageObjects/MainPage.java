package pageObjects;

import com.Base;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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


    public ElementsCollection getIngredientsTransitionPanel() {
        return ingredientsTransitionPanel;
    }

    public void clickToTransitionPanelElement(SelenideElement transitionPanelElement) {
        transitionPanelElement.click();
    }

    public boolean isIngredientSelected(String ingredientName) {
       return selectedTransitionPanelIngredient.shouldBe(visible).shouldHave(text(ingredientName)).isDisplayed();
    }

    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(visible).isDisplayed();
    }

    public boolean isIngredientHeadingVisible(String ingredientName) {
        return $(byXpath(String.format(".//h2[text()='%s']", ingredientName))).shouldBe(visible).isDisplayed();
    }

    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }
}
