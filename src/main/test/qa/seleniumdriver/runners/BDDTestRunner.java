package qa.seleniumdriver.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This class defines the glue that connects the feature files, the java Step Definitions and the configurations for the Cucumber Tags and Output format Use to
 * test grid
 *
 *
 */

//@RunWith(Cucumber.class)
//@CucumberOptions(format = { "pretty", "html:target/results",
//        "json:target/results.json" }, features = "src/main/resources/features", glue = { "src/main/java/com/qa/seleniumcommons/stepdefinitions" },
//        tags = { "@chrometest" })
@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/cucumber-html/alltestcases", "json:target/cucumber-json-report.json"},
        glue={"qa.seleniumdriver.stepdefinitions"},
        features={"src/main/resources/features"},
        tags={"@chrometest"}
)
public class BDDTestRunner {

//    @BeforeClass
//    public static void setup() {
//        System.out.println("Ran the before");
//    }
//
//    @AfterClass
//    public static void teardown() {
//        System.out.println("Ran the after");
//        if (BrowserDriver.whereToRun != null && BrowserDriver.whereToRun.equalsIgnoreCase("local")) {
//            // BrowserDriverSteps.displayHtmlResult();
//        }
//    }
}