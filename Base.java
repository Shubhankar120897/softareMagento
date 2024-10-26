package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop = new Properties();

    public static WebDriver initializeDriver() throws IOException {
        // Load properties
        prop.load(new FileInputStream("src/main/resources/config.properties"));

        // Browser setup
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

        // Configure timeouts and window settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return driver;
    }
    
    public static WebDriverWait getWait() {
        return wait;
    }
    
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
