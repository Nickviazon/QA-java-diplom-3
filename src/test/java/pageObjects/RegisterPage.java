package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public void setFields(String name, String email, String password) {
        nameField.shouldBe(and("can be clicked", visible, enabled)).click();
        nameField.sendKeys(name);
        sleep(1000);
        emailField.shouldBe(and("can be clicked", visible, enabled)).click();
        emailField.sendKeys(email);
        sleep(1000);
        passwordField.shouldBe(and("can be clicked", visible, enabled)).click();
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean isInputErrorMessageVisible() {
        return inputErrorMessage.isDisplayed();
    }
}
