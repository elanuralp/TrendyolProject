package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.DriverManager;

import java.util.UUID;

public class RegisterAndLogin {

    private final DriverManager driverManager;

    private HomePage homePage;
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    public RegisterAndLogin(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private String registeredEmail;
    private String registeredPassword;


    @When("the user navigates to the registration page")
    public void the_user_navigates_to_the_registration_page() {
        homePage.goToLoginOrRegister();
        registrationPage = new RegistrationPage(driver);
    }

    @Given("the user is on the Trendyol homepage")
    public void the_user_is_on_the_trendyol_homepage() {
        driver = driverManager.getDriver(); // Get the driver from DriverManager
        driver.get("https://www.trendyol.com/");
        homePage = new HomePage(driver); // Initialize homePage here
        // Handle popups if they appear on the homepage load
        homePage.acceptCookiesIfPresent();
        homePage.closeGenderPopupIfPresent();
    }


    @When("the user registers with a unique email and password")
    public void the_user_registers_with_a_unique_email_and_password() {
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        registeredEmail = "testuser" + uniqueId + "@yopmail.com";
        registeredPassword = "Testpassword123!";
        registrationPage.register(registeredEmail, registeredPassword);
    }


    @Then("the registration should be successful")
    public void the_registration_should_be_successful() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(), "Registration failed");
    }


    @When("the user logs out")
    public void the_user_logs_out() {
        driver.get("https://www.trendyol.com/");
        homePage = new HomePage(driver);
        homePage.logout();
    }
    @When("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        homePage.goToLoginOrRegister();
        loginPage = new LoginPage(driver);
    }
    @When("the user logs in with the registered email and password")
    public void the_user_logs_in_with_the_registered_email_and_password() {
        loginPage.login(registeredEmail, registeredPassword);
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");

    }













}
