package posmy.interview.qa.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchPage {
    RemoteWebDriver driver;

    public GoogleSearchPage(RemoteWebDriver drv) {
        driver = drv;
    }

    /*
        Steps to search for a string in search page
        1. Find the Search field element
        2. Key in the string into the Search field
        3. Click on ENTER key
     */
    public void searchForString(String searchString) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@title='Search']"));
        searchInput.sendKeys(searchString);
        searchInput.sendKeys(Keys.ENTER);
    }

    /*
        Step to validate the page title
        1. Get the actual page title as it's loaded
        2. Validate that the page title end with the provided string
        NOTE : Google prefix the search string with "<SEARCH_STRING> - Google Search"
     */
    public void validatePageTitle(String expectedTitle) {
        String actualPageTitle = driver.getTitle();
        assertTrue(actualPageTitle.endsWith(expectedTitle));
    }

    /*
        Step to validate that a section of a given text exists
        1. Find an element containing the expected label
        2. Validate that the element is displayed
     */
    public void elementExistByLabel(String label) {
        WebElement elmt = driver.findElement(By.xpath("//*[text()='"+ label +"']"));
        assertTrue(elmt.isDisplayed());
    }

    /*
        Step to navigate to a search result
        1. Find an element containing part of the URL
        2. Get the full URL as available in the search page
        3. Click on the URL to navigate to the page
        4. Get the updated URL when new page loaded
        5. Validate that the current URL similar to what is listed in the search page
     */
    public void navigateToUrl(String partialLink) {
        WebElement elmt = driver.findElement(By.partialLinkText(partialLink));

        String extractedLink = elmt.getAttribute("href");
        elmt.click();

        String updatedLink = driver.getCurrentUrl();

        assertEquals(extractedLink,updatedLink);
    }
}
