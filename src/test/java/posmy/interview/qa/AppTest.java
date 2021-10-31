package posmy.interview.qa;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import posmy.interview.qa.driver.RemoteWebDriverFactory;
import posmy.interview.qa.steps.GoogleSearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    RemoteWebDriver driver = RemoteWebDriverFactory.chrome();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    /*
        Step to start the chrome browser and go to required URL
     */
    @And("^I start the browser and navigate to (.*)?$")
    public void startBrowser(String url) {
        driver.get(url);
    }

    /*
        Step to close the browser
     */
    @And("^I close the browser?$")
    public void closeBrowser() {
        driver.close();
    }

    /*
        Step to search for a string in the Google Search page
        Eg : I search for Covid-19 in Malaysia
     */
    @And("^I search for (.*)?$")
    public void searchForString(String searchString) {
        GoogleSearchPage search = new GoogleSearchPage(driver);
        search.searchForString(searchString);
    }

    /*
        Step to validate that the page title is as expected
        Eg: I validate the Page Title is Google Search
     */
    @And("^I validate the Page Title is (.*)?$")
    public void validatePageTitle(String expectedPageTitle) {
        GoogleSearchPage search = new GoogleSearchPage(driver);
        search.validatePageTitle(expectedPageTitle);
    }

    /*
        Step to validate that the section with expected heading is available
        Eg: I validate section with heading Top stories is available
     */
    @And("^I validate section with heading (.*) is available?$")
    public void validateSection(String expectedSection) {
        GoogleSearchPage search = new GoogleSearchPage(driver);
        search.elementExistByLabel(expectedSection);
    }

    /*
        Step to verify that redirection works for the expected URL
        eg: I verify clicking on link containing moh.gov.my redirect to correct page
     */
    @And("^I verify clicking on link containing (.*) redirect to correct page?$")
    public void getFirstResultFromSection(String partialLink) {
        GoogleSearchPage search = new GoogleSearchPage(driver);
        search.navigateToUrl(partialLink);
    }
}