package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header extends BasePage{

    // Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    // Кнопка "Лента заказов"
    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeedButton;

    // Лого "Stellar burgers"
    @FindBy(how = How.CSS, using = "nav>div>a[href='/']")
    private SelenideElement logoButton;

    // Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private  SelenideElement accountButton;

    @Step("Нажата кнопка конструктора в шапке")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Нажата кнопка ленты заказов в шапке")
    public void clickOrderFeedButton() {
        ordersFeedButton.click();
    }

    @Step("Нажато лого сайта в шапке")
    public void clickLogoButton() {
        logoButton.click();
    }

    @Step("Нажата кнопка личного кабинета в шапке")
    public void clickAccountButton() {
        accountButton.click();
    }
}
