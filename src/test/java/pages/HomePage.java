package pages;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(css="input[data-testid='suggestion']")
    WebElement searchBox;

    @FindBy(css = "i[data-testid='search-icon']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id='gender-popup-modal']/div/div/div[1]/svg")
    WebElement closeGenderPopupButton;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    WebElement acceptCookiesButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String keyword) {
        acceptCookiesIfPresent();
        closeGenderPopupIfPresent();
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public void closeGenderPopupIfPresent(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(closeGenderPopupButton));
            closeGenderPopupButton.click();
        }catch (Exception e){
            //Pop up not presenets nothing to do
        }
    }

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Cookie popup not present, do nothing
        }
    }



}
