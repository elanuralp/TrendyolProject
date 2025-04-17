package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverManager;

public class Hooks {

    private final DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void setUp() {
        // Initialize the WebDriver instance before each scenario
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverManager.setDriver(driver);
    }

    @After
    public void tearDown() {
        // Quit the WebDriver instance after each scenario
        WebDriver driver = driverManager.getDriver();
        if (driver != null) {
            //driver.quit();
        }
    }
}
