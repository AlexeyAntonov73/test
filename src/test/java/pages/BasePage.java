package pages;

import helpers.Waiters;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected int timeout;

    public BasePage(WebDriver driver, String webUrl, int timeout) {
        this.timeout = timeout;
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            Waiters.urlContains(driver, webUrl, timeout);
        } catch (TimeoutException e) {
            throw new IllegalStateException(webUrl + " page is not present");
        }
    }
}
