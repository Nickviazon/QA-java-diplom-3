package tests;

public abstract class AbstractBaseTest {

    protected final String baseUrl = setBaseUrlFromParameters();
    protected final String registerPath = "/register";
    protected final String loginPath = "/login";
    protected final String forgotPasswordPass = "/forgot-password";

    public static void setBrowserFromParameters() {
        String browserParameter = System.getProperty("browser");
        if (browserParameter.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        } else if (browserParameter.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        }
    }

    public String setBaseUrlFromParameters() {
        return System.getProperty("url");
    }
}
