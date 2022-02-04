package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // Раздел "Булки" в панели выбора ингредиентов
    @FindBy(how = How.XPATH, using = ".//div[span='Булки']")
    private SelenideElement bunTransitionPanel;

    // Раздел "Соусы" в панели выбора ингредиентов
    @FindBy(how = How.XPATH, using = ".//div[span='Соусы']")
    private SelenideElement sauceTransitionPanel;

    // Раздел "Начинки" в панели выбора ингредиентов
    @FindBy(how = How.XPATH, using = ".//div[span='Начинки']")
    private SelenideElement fillingTransitionPanel;

    // Раздел "Булки" в выборе ингредиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunHeading;

    // Раздел "Соусы" в выборе ингредиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement sauceHeading;

    // Раздел "Начинки" в выборе ингредиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingHeading;

    // Кнопка входа
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти')]")
    private SelenideElement enterAccountButton;

    public void clickBunTransitionPanel() {
        bunTransitionPanel.click();
    }

    public void clickSauceTransitionPanel() {
        sauceTransitionPanel.click();
    }

    public void clickFillingTransitionPanel() {
        fillingTransitionPanel.click();
    }

    public boolean isBunHeadingDisplayed() {
        return bunHeading.isDisplayed();
    }

    public boolean isSauceHeadingDisplayed() {
        return sauceHeading.isDisplayed();
    }

    public boolean isFillingHeadingDisplayed() {
        return fillingHeading.isDisplayed();
    }

    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }
}
