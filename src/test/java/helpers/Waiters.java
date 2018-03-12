package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
    public static void pageLoadTimeout(WebDriver driver, int timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    public static void implicitlyWait(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void visibilityOf(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(locator));
    }

    public static void elementToBeClickable(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void urlContains(WebDriver driver, String webUrl, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.urlContains(webUrl));
    }
}
