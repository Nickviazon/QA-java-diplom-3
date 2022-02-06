package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;


public class LoginPage extends BasePage {

    // Поле ввода email
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Email']]/input")
    private SelenideElement emailField;

    // Поле ввода пароля
    @FindBy(how = How.CSS, using = "div>input[name='Пароль']")
    private SelenideElement passwordField;

    // Кнопка входа
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    // Ссылка на страницу регистрации
    @FindBy(how = How.CSS, using = "a[href='/register']")
    private SelenideElement registerLink;

    // Ссылка на страницу восстановления пароля
    @FindBy(how = How.CSS, using = "a[href='/forgot-password']")
    private SelenideElement forgotPasswordLink;

    public void setEmailAndPasswordFields(String email, String password) {
        sleep(500);
        // борьба с автозаполнением данных у Ябраузера
        // (сейчас бы автоматическое сохранение/заполнение  логина-пароля пихать без подтверждения пользователя)
        // .clear() не срабатывает в Ябраузере, поле остается автозаполненым, пришлось обходить
        if (emailField.getText() != null) {
            emailField.shouldBe(and("can be clickable", exist, visible, enabled)).click();
            emailField.sendKeys(Keys.CONTROL + "a");
            emailField.sendKeys(Keys.DELETE);
        }
        emailField.setValue(email);
        if (emailField.getText() != null) {
            passwordField.click();
            passwordField.sendKeys(Keys.CONTROL + "a");
            passwordField.sendKeys(Keys.DELETE);
        }
        passwordField.setValue(password);
    }

    public boolean isInputFieldsAndEnterButtonVisible() {
        return emailField.shouldBe(exist).isDisplayed() &&
                passwordField.shouldBe(exist).isDisplayed() &&
                enterButton.shouldBe(exist).isDisplayed();
    }

    public void clickEnterButton() {
        enterButton.shouldBe(exist).click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}
