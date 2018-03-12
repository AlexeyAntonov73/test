package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    public static WebDriver createDriver(String browserName, String driverPath, int timeout)
            throws IllegalArgumentException {
        WebDriver driver;
        if ("chrome".equals(browserName) || "opera".equals(browserName)) {
            if (!driverPath.isEmpty()) {
                System.setProperty("webdriver.chrome.driver", driverPath);
            }
            driver = new ChromeDriver();
        } else if ("firefox".equals(browserName)) {
            if (!driverPath.isEmpty()) {
                System.setProperty("webdriver.firefox.driver", driverPath);
            }
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Chosen browser not supported");
        }
        Waiters.pageLoadTimeout(driver, timeout);
        Waiters.implicitlyWait(driver, timeout);
        return driver;
    }
}
