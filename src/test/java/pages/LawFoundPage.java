package pages;

import helpers.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class LawFoundPage extends BasePage {

    private static final String PAGE_URL = "/law/found/";

    private final String selectedViewAndRegionText = "//div[@class='search-extended-string']//span[contains(text(), '%s')]";

    @FindBy(css = "ul[data-filtr-name='pubDiv']")
    private WebElement resultsInLeftBlock;

    @FindBy(id = "searchResultsSection")
    private WebElement searchResultsSection;

    @FindBy(id = "ex-search-string")
    private WebElement textSearch;

    public LawFoundPage(WebDriver driver, int timeout) {
        super(driver, PAGE_URL, timeout);
    }

    @Step("Проверяем наличае блоков, соответствие текста заголовка, соответствие выбранных значений вида и региона")
    public boolean checkBlocks(String view, String region, String textForSearch) {
        WebElement selectedView = driver.findElement(By.xpath(String.format(selectedViewAndRegionText, view)));
        WebElement selectedRegion = driver.findElement(By.xpath(String.format(selectedViewAndRegionText, region)));
        try {
            Waiters.visibilityOf(driver, resultsInLeftBlock, timeout);
            Waiters.visibilityOf(driver, searchResultsSection, timeout);
            Waiters.visibilityOf(driver, selectedView, timeout);
            Waiters.visibilityOf(driver, selectedRegion, timeout);
            String text = textSearch.getText();
            text = text.substring(1, text.length() - 1);
            Assert.assertEquals(textForSearch, text);
        } catch (TimeoutException | AssertionError e) {
            return false;
        }
        return true;
    }
}
