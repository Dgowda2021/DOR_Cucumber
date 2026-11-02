package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    private WebDriver driver;
    public WebDriverWait wait;
 public Base_PO(){
     PageFactory.initElements(getDriver(),this);
 }
 public WebDriver getDriver(){
     return DriverFactory.getDriver();
 }

    public void initializeDriver() {
        driver = DriverFactory.getDriver();

        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        }
    }
    public void navigateTo_URL(String url){
        initializeDriver();
        getDriver().get(url);
    }
    public void sendKeys(By by, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        WebElement webElement  = wait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.clear();
        webElement.sendKeys(textToType);
    }
    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement .clear();
        webElement .sendKeys(textToType);
    }

    public void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitFor(By by){
     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void assertElementText(WebElement element, String expectedText, String message) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText().trim(), expectedText, message);
    }

    public void waitForAlert_And_ValidateText(String text){
     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_text, text);
    }



}
