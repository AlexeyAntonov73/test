package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class RecommendationsPage extends BasePage {

    private static final String PAGE_URL = "/recommendations";

    @FindBy(css = "#main_menu_law > a")
    private WebElement lawNavButton;

    public RecommendationsPage(WebDriver driver, int timeout) {
        super(driver, PAGE_URL, timeout);
    }

    @Step("Переходим в раздел правовая база по кнопке со стартовой страницы")
    public LawPage goToSectionLaw() {
        Waiters.elementToBeClickable(driver, lawNavButton, timeout);
        lawNavButton.click();
        return new LawPage(driver, timeout);
    }
}
