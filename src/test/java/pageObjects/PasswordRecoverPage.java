package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoverPage extends BasePage {

    // Поле ввода Email
    @FindBy(how = How.CSS, using = "div>input[name='name']")
    private SelenideElement emailField;

    // Кнопка восстановления пароля
    @FindBy(how = How.XPATH, using = ".//button[text()='Восстановить']")
    private SelenideElement recoverPasswordButton;

    // Ссылка на страницу входа
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private SelenideElement loginLink;

    @Step("Поле ввода email заполнено")
    public void setEmailField(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    @Step("Нажата кнопка восстановления пароля")
    public void clickRecoverButton() {
        recoverPasswordButton.click();
    }

    @Step("Нажата ссылка на переход к странице входа")
    public void clickLoginLink() {
        loginLink.click();
    }
}
