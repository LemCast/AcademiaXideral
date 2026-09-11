package base;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    private static final long TEST_DELAY_MS = Long.parseLong(System.getProperty("testDelayMs", "1500"));

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.createChromeDriver();
        driver.get("https://www.santander.com.mx/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                new WebDriverWait(driver, Duration.ofMillis(TEST_DELAY_MS)).until(d -> false);
            } catch (TimeoutException expected) {

            }
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
