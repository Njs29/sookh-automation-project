package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    public static Actions actions;

    @BeforeSuite
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Create actions object
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterSuite
    public void endSession() {
        driver.quit();
    }


}
