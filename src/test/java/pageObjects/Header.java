package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {

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

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickOrderFeedButton() {
        ordersFeedButton.click();
    }

    public void clickLogoButton() {
        logoButton.click();
    }

    public void clickAccountButton() {
        accountButton.click();
    }
}
