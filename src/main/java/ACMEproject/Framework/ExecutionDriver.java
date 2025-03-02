package ACMEproject.Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ExecutionDriver extends PropertyKey {

    public static WebDriver wd;
    private static final Logger logger = LogManager.getLogger(ExecutionDriver.class);

    @BeforeSuite
    public void setUp() {
        try {
            Properties properties = new Properties();
            try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Acer\\IdeaProjects\\ACME-AutomationProject\\src\\main\\java\\ACMEproject\\Utility\\Testdata.properties")) {
                properties.load(inputStream);


                String urlValue = properties.getProperty(URL_KEY);

                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver();
                wd.manage().window().maximize();
                wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                logger.info("WebDriver initialized successfully.");
                wd.get(urlValue);
                logger.info("ACME URL opened successfully.");
            }
        } catch (Exception e) {
            logger.error("An error occurred during setup: " + e.getMessage());
        }
    }

    /*@AfterSuite
    public void tearDown() {
        if (wd != null) {
            wd.quit(); // Close the browser and clean up
            logger.info("WebDriver closed successfully.");
        }
    }*/
}
