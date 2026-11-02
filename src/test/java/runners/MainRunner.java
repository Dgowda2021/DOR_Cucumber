package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "",
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
