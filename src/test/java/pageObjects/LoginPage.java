package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // Поле ввода имени
    @FindBy(how = How.CSS, using = "div>input[name='name']")
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
        emailField.sendKeys(email);
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
