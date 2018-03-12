package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {

    private static final String PAGE_URL = "/auth";

    @FindBy(id = "wf-enter")
    private WebElement authTitleButton;

    @FindBy(id = "email")
    private WebElement emailTextInput;

    @FindBy(id = "password")
    private WebElement passwordTextInput;

    @FindBy(id = "customer-enter")
    private WebElement customerEnterButton;

    public LoginPage(WebDriver driver, int timeout) {
        super(driver, PAGE_URL, timeout);
    }

    @Step("Переключаемся на вкладку \"Вход в систему\", вводим логин и пароль, нажимаем \"Войти\"")
    public RecommendationsPage login(String email, String password) {
        authTitleButton.click();
        emailTextInput.sendKeys(email);
        passwordTextInput.sendKeys(password);
        customerEnterButton.click();
        return new RecommendationsPage(driver, timeout);
    }

}
