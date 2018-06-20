package qa.seleniumdriver.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import qa.seleniumdriver.BrowserDriver;

public class BrowserDriverStepDefs {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BrowserDriverStepDefs.class);

    private Class<? extends Throwable> expectedException;

    private By googleSearchTextBox = By.className("#lst-ib");
    private By akiliInteractiveLink = By.className("#rso > div:nth-child(1) > div > div > div > div > h3 > a");


    @Given("^Im on the google page$")
    public void imOnTheGooglePage() throws Throwable {
        BrowserDriver.setBrowserName("chrome");
        BrowserDriver.setPathToChrome("src/main/resources/chromedriver");
        BrowserDriver.setWhereToRun("local");
        log.info("I open the page: " + "http://www.google.com");
        try {
            BrowserDriver.navigateTo("http://www.google.com");
        } catch (Exception e) {
            throwExceptionIfNotExpected(e);
        }
    }


    private void throwExceptionIfNotExpected(Exception pException) throws Exception {
        if (!isAnExpectedException(pException)) {
            throw pException;
        }
    }

    private boolean isAnExpectedException(Exception pException) {
        if (pException.getCause().getClass().equals(expectedException)) {
            expectedException = null; // reset to detect unused expected exception
            return true;
        } else if (pException.getCause().getCause().getClass().equals(expectedException)) // retry with sub cause
        {
            expectedException = null; // reset to detect unused expected exception
            return true;
        } else {

            return false;

        }
    }


    @Then("^validate search results$")
    public void validateSearchResults() {
        BrowserDriver.type(googleSearchTextBox, "akili interactive");
    }

    @When("^a search term is entered$")
    public void aSearchTermIsEntered() {
        Assert.assertTrue(BrowserDriver.isElementVisible(akiliInteractiveLink));
    }
}
