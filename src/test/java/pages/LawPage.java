package pages;

import helpers.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LawPage extends BasePage {

    private static final String PAGE_URL = "/law";

    @FindBy(id = "search-button-extended")
    private WebElement searchByRequisitesButton;

    @FindBy(id = "search-text")
    private WebElement searchFieldTextInput;

    @FindBy(id = "button-search-extended")
    private WebElement searchButton;

    @FindBy(css = "#typelist > li:nth-of-type(4)")
    private WebElement elementOnTypeListButton;

    @FindBy(css = "#regionlist > li:nth-of-type(2)")
    private WebElement elementOnRegionListButton;

    @FindBy(css = "#search-extended-wrapper .ico_content_close")
    private WebElement searchExtendedCloseButton;

    public LawPage(WebDriver driver, int timeout) {
        super(driver, PAGE_URL, timeout);
    }

    @Step("Нажимаем на кнопку \"по реквизитам\" заполняем поля, выбираем нужные варианты в списках и нажимаем кнопку \"Найти\"")
    public LawFoundPage fillingFieldForSearch(String textForSearch) {
        Waiters.visibilityOf(driver, searchByRequisitesButton, timeout);
        searchByRequisitesButton.click();
        //Wait for close button to assure that form is fully visible
        Waiters.visibilityOf(driver, searchExtendedCloseButton, timeout);
        searchFieldTextInput.sendKeys(textForSearch);
        searchFieldTextInput.sendKeys(Keys.TAB);
        elementOnTypeListButton.click();
        elementOnRegionListButton.click();
        searchButton.click();
        return new LawFoundPage(driver, timeout);
    }

}
