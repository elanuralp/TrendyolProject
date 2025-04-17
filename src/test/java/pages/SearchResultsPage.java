package pages;

import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isResultDisplayed(String keyword) {
        return driver.getPageSource().toLowerCase()
                .contains(keyword.toLowerCase());
    }

}
