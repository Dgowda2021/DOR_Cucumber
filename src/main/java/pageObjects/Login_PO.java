package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_Vars;

public class Login_PO extends Base_PO {
    private @FindBy(id = "username")
    WebElement usernameField;
    private @FindBy(id = "password")
    WebElement passwordField;
    private @FindBy(how = How.XPATH, using = "//button[normalize-space()='Sign in']")
    WebElement loginButton;
    private @FindBy(xpath = "//h1[normalize-space()='Dashboard']")
    WebElement dashboardElement;
    private @FindBy(xpath ="//div[normalize-space()='Invalid credentials']")
    WebElement invalidCredentialsMessage;

    // Add any page-specific methods or locators for the login page here
    public Login_PO() {
        // Constructor
        super();
    }

    public void navigateTo_DOR_Login_Page() {
        navigateTo_URL(Global_Vars.WEBDRIVER_DOR_URL);
    }

    public void setUsernameField(String username) {
        sendKeys(usernameField, username);
    }

    public void setPasswordField(String password) {
        sendKeys(passwordField, password);
    }

    public void setInvalidUsernameField(String invalidUsername) {
        sendKeys(usernameField, invalidUsername);
    }

    public void setInvalidPasswordField(String invalidPassword) {
        sendKeys(passwordField, invalidPassword);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void success_Navigate_Dashboard() {
        assertElementText(dashboardElement, "Dashboard", "Dashboard page was not displayed");
    }
    public void verifyInvalidCredentialsMessage() {
        assertElementText(invalidCredentialsMessage, "Invalid credentials", "Invalid credentials message was not displayed");
    }
    public void setSpecific_EmailId(String userId){

    }
}
