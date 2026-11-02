package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    private Login_PO login_po;
    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }
    // Initialize after the Cucumber @Before hook runs
    @Given("I am on the DoR login page")
    public void i_am_on_the_do_r_login_page() {
        initializeDriver();
        login_po.navigateTo_DOR_Login_Page();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_username_and_password(String username, String password) {
        //initializeDriver();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='you@company.com']"))).sendKeys(username);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your password']"))).sendKeys(password);
//        sendKeys(By.xpath("//input[@placeholder='you@company.com']"), username);
//        sendKeys(By.xpath("//input[@placeholder='Enter your password']"), password);
        login_po.setUsernameField(username);
        login_po.setPasswordField(password);
    }

    @When("I enter invalid username or password")
    public void i_enter_invalid_username_or_password() {
        //initializeDriver();
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='you@company.com']"))).sendKeys("invalidUsername@example.com");
//        sendKeys(By.xpath("//input[@placeholder='you@company.com']"), "invalidUsername@example.com");
//       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your password']"))).sendKeys("invalidPassword");
//        sendKeys(By.xpath("//input[@placeholder='Enter your password']"), "invalidPassword");
        login_po.setInvalidUsernameField("Invalid@gmail.com");
        login_po.setInvalidPasswordField("InvalidPassword123");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
       // initializeDriver();
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign in']"))).click();
//        clickElement(By.xpath("//button[normalize-space()='Sign in']"));
        login_po.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
       // initializeDriver();
//        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
//        Assert.assertEquals(dashboardElement.getText().trim(), "Dashboard", "Dashboard page was not displayed");
//        assertElementText(By.xpath("//h1[normalize-space()='Dashboard']"), "Dashboard", "Dashboard page was not displayed");
        login_po.success_Navigate_Dashboard();

    }

    @Then("I should see an error message indicating invalid credentials")
    public void i_should_see_an_error_message_indicating_invalid_credentials() {
       // initializeDriver();
        // Verify the actual error text and locator in the application.
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Invalid credentials']")));
//        Assert.assertEquals(errorMessage.getText().trim(), "Invalid credentials", "Invalid credentials error message was not displayed");
        //assertElementText(By.xpath("//div[normalize-space()='Invalid credentials']"), "Invalid credentials", "Invalid credentials error message was not displayed");
        login_po.verifyInvalidCredentialsMessage();
    }
}
