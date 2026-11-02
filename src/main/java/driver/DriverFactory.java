
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver =
            new ThreadLocal<>();

    private DriverFactory() {
        // Prevent object creation
    }

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {

        WebDriver driver;

        switch (getBrowserType()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser type: " + getBrowserType());
        }

        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;

        try {
            Properties properties = new Properties();

            FileInputStream fileInputStream = new FileInputStream("src/main/java/properties/config.properties");

            try {
                properties.load(fileInputStream);
            } finally {
                fileInputStream.close();
            }

            browserType = properties.getProperty("browser");

            if (browserType == null || browserType.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Browser property is missing or empty in config.properties");
            }

            return browserType.toLowerCase().trim();

        } catch (IOException ex) {
            throw new IllegalStateException(
                    "Error reading config.properties file: "
                            + ex.getMessage(), ex);
        }
    }

    public static void cleanupDriver() {
        WebDriver driver = webDriver.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            webDriver.remove();
        }
    }
}
