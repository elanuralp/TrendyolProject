package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    @FindBy(css="input[data-testid='suggestion']")
    WebElement searchBox;

    @FindBy(css = "i[data-testid='search-icon']")
    WebElement searchButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }



}
