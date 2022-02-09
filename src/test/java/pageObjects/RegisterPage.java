package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {

    // Поле ввода имени
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Имя']]/input")
    private SelenideElement nameField;

    // Поле ввода email
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Email']]/input")
    private SelenideElement emailField;

    // Поле ввода пароля
    @FindBy(how = How.CSS, using = "div>input[name='Пароль']")
    private SelenideElement passwordField;

    // Сообщение о некорректном вводе
    @FindBy(how = How.CSS, using = "p.input__error")
    private SelenideElement inputErrorMessage;

    // Кнопка регистрации
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    // Ссылка на страницу входа
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private SelenideElement loginLink;

    @Step("Заполняются данные о новом пользователе")
    public void setFields(String name, String email, String password) {
        nameField.shouldBe(Condition.exist).click();
        nameField.clear();
        nameField.setValue(name);
        emailField.click();
        emailField.setValue(email);
        passwordField.click();
        passwordField.setValue(password);
    }

    @Step("Нажата кнопка регистрации нового пользователя")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Нажата ссылка на странцу входа из страницы регистрации")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Проверка на наличие сообщения об ошибке ввода")
    public boolean isInputErrorMessageVisible() {
        return inputErrorMessage.isDisplayed();
    }
}
