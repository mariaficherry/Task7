package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.*;
import static utils.ConfigDataUtility.url;

public abstract class BaseTest {
    Browser browser;

    @BeforeMethod
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.goTo(url);
        browser.maximize();
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }
}
