
package stepDefinitions.base;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Hooks {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterStep
    public void  captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs((OutputType.BYTES));
            scenario.attach(screenshot, "image/png", "screenshot_" + timeMilliseconds);
        }
    }

    @After
    public void tearDown() {
        DriverFactory.cleanupDriver();
    }
}
