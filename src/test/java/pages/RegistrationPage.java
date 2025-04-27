package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Üye Ol']")
    WebElement registerTab;

    @FindBy(css = "#register-email")
    WebElement emailInput;

    @FindBy(css = "input[data-testid='password-input']")
    WebElement passwordInput;

    @FindBy(css = "div.recaptcha-checkbox-border")
    WebElement recaptchaCheckbox;

    @FindBy(css = "input[name='kvkkCheckbox']")
    WebElement kvkkCheckbox;

    @FindBy(css = "input[name='privacyCheckbox']")
    WebElement privacyCheckbox;

    @FindBy(css = "input[name='termsCheckbox']")
    WebElement termsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'ÜYE OL')]")
    WebElement registerButton;

    @FindBy(css = ".account-user")
    WebElement accountUserIndicator;



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToRegisterTab(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerTab)).click();
    }

    public void register(String email, String password){
        goToRegisterTab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        passwordInput.sendKeys(password);

        //necessary checkboxes
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(kvkkCheckbox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(privacyCheckbox)).click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(recaptchaCheckbox)).click();
            // try to get over the reCAPTCHA
            Thread.sleep(2000); // Example pause, not recommended in real tests
        } catch (Exception e) {
            System.out.println("ReCAPTCHA checkbox not found or clickable, or challenge appeared.");
        }

        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();


    }

    public boolean isRegistrationSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(accountUserIndicator));
            return accountUserIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
