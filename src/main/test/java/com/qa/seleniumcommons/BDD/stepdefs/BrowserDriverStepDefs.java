package com.qa.seleniumcommons.BDD.stepdefs;

import cucumber.api.java.en.When;
import com.qa.seleniumcommons.BrowserDriver;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class BrowserDriverStepDefs {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BrowserDriverStepDefs.class);

    private Class<? extends Throwable> expectedException;


    @When("^I'm on the google page$")
    public void i_m_on_the_google_page() throws Throwable {
        BrowserDriver.setBrowserName("chrome");
        BrowserDriver.setPathToChrome("src/main/test/resources/chromedriver");
        BrowserDriver.setWhereToRun("local");
        log.info("I open the page: " + "http://www.google.com");
        try {
            BrowserDriver.loadPage("http://www.google.com");
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
}
