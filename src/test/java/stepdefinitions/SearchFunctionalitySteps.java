package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.DriverManager;

public class SearchFunctionalitySteps {

    private final DriverManager driverManager;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    public SearchFunctionalitySteps(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Given("the user is on the Trendyol homepage")
    public void the_user_is_on_the_trendyol_homepage() {
        driver = driverManager.getDriver();
        driver.get("https://www.trendyol.com/");
        homePage = new HomePage(driver);

    }
    @When("the user searches for {string}")
    public void the_user_searches_for(String string) {
        homePage.searchFor(string);
        searchResultsPage = new SearchResultsPage(driver);
    }
    @Then("search results for {string} are displayed")
    public void search_results_for_are_displayed(String searchTerm) {
        Assert.assertTrue(
                searchResultsPage.isResultDisplayed(searchTerm),
                "Search results do not contain the keyword: " + searchTerm
        );
        //driver.quit();
    }
}
