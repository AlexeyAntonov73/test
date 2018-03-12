package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {

    @FindBy(id = "user-enter")
    private WebElement loginOrRegistrationButton;

    public HomePage(WebDriver driver, String webUrl, int timeout) {
        super(driver, webUrl, timeout);
    }

    @Step("Переходим на страницу входа")
    public LoginPage proceedToAuthorization() {
        loginOrRegistrationButton.click();
        return new LoginPage(driver, timeout);
    }

}
