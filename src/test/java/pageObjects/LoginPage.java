package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {

    // Поле ввода email
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Email']]/input")
    private SelenideElement emailField;

    @FindBy (how = How.XPATH, using = ".//div[contains(@class, 'input_status_active')]/input")
    private SelenideElement activeEmailField;

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
        emailField.shouldBe(and("can be clickable", visible, disabled), Duration.ofSeconds(2)).click();
        activeEmailField.sendKeys(email);
        passwordField.shouldBe(exist, Duration.ofSeconds(2)).click();
        passwordField.sendKeys(password);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}
