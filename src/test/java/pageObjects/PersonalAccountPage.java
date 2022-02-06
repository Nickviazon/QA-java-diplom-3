package pageObjects;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class PersonalAccountPage {

    // Поле "Имя"
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Имя']]")
    private SelenideElement nameField;

    // Поле "Логин"
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Логин']]")
    private SelenideElement loginField;

    // Поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Пароль']]")
    private SelenideElement passwordField;

    // Кнопка выхода
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step("Нажата кнопка выхода из личного кабинета")
    public void clickTheExitButton() {
        exitButton.shouldBe(and("can be clicked", exist, visible, enabled)).click();
    }

    @Step("Проверка что все пользовательские поля отображаются")
    public boolean isUserFieldsAreVisible() {
        return nameField.shouldBe(and("is visible", exist, visible)).isDisplayed() &&
                loginField.shouldBe(and("is visible", exist, visible)).isDisplayed() &&
                passwordField.shouldBe(and("is visible", exist, visible)).isDisplayed();
    }

    @Step("Получение значения поля Имя")
    public String getNameFieldTextValue() {
        return nameField.$(byXpath("input")).getValue();
    }

    @Step("Получение значения поля Логин")
    public String getLoginFieldTextValue() {
        return loginField.$(byXpath("input")).getValue();
    }
}
