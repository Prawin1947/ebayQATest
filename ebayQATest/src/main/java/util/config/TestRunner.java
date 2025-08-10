package util.config;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/test/java/features/ui/functional",
        glue = "src/main/java/steps/ui/functional",
        tags = "@functional",
        plugin = {"pretty", "html:target/cucumber-reports/html-report.html"},
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;


    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

}
