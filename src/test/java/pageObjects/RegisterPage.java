package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    // Поле ввода имени
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Имя']]")
    private SelenideElement nameField;

    // Поле ввода email
    @FindBy(how = How.XPATH, using = ".//div[label[text()='Email']]")
    private SelenideElement emailField;

    // Поле ввода пароля
    @FindBy(how = How.CSS, using = "div>input[name='Пароль']")
    private SelenideElement passwordField;

    // Кнопка регистрации
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    // Ссылка на страницу входа
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private SelenideElement loginLink;

    public void setFields(String name, String email, String password) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
