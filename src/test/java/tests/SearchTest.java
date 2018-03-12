package tests;

import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class SearchTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browserName", "webUrl", "driverPath", "timeoutValue"})
    public void setEnvironment(String browserName, String webUrl, @Optional("") String driverPath, int timeout) {
        this.driver = DriverFactory.createDriver(browserName, driverPath, timeout);
        driver.get(webUrl);
    }

    @Test
    @Parameters({"userLogin", "userPassword", "webUrl", "timeoutValue"})
    public void checkSearchByRequisites(String login, String password, String web_Url, int timeout) {
        HomePage homePage = new HomePage(driver, web_Url, timeout);
        boolean result = homePage
                .proceedToAuthorization()
                .login(login, password)
                .goToSectionLaw()
                .fillingFieldForSearch("налог")
                .checkBlocks("Постановление", "Москва", "налог");

        Assert.assertTrue(result);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
