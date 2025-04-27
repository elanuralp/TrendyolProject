package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@class='q-secondary q-button-medium q-button tab button mr-5 left active']//span[contains(text(),'Giriş Yap')]")
    WebElement loginTab;

    @FindBy(css = "#login-email")
    WebElement emailInput;

    @FindBy(css = "#login-password")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit'] span")
    WebElement submitButton;

    @FindBy(css = ".account-user") // Assuming this appears after successful login
    WebElement accountUserIndicator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginTab)).click();
    }

    public void login(String email, String password) {
        goToLoginTab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(accountUserIndicator));
            return accountUserIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }





}
