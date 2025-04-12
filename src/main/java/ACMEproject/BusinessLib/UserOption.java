package ACMEproject.BusinessLib;

import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import ACMEproject.Pages.UseroptionsPage;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class UserOption extends ExecutionDriver {
    public static final Logger logger= LogManager.getLogger(Login.class);

    public static WebDriver wd;
    public UseroptionsPage useroptionsPage;
    public static int screenshotcount = 0;
    Properties properties = new Properties();


    public UserOption(WebDriver wd) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Acer\\IdeaProjects\\ACME-AutomationProject\\src\\main\\java\\ACMEproject\\Utility\\Testdata.properties");
        properties.load(inputStream);
        this.wd=wd;
        useroptionsPage = new UseroptionsPage(wd);
    }

    public void DownloadClientandSupportMenu(){

        Actions action=new Actions(wd);
        WebElement useroptionMenu=useroptionsPage.UserOptionMenu ;
        WebElement DownloadclientsupportMeu=useroptionsPage.DownloadClientandSupportMenu;
        action.moveToElement(useroptionMenu).perform();
        action.moveToElement(DownloadclientsupportMeu).click().perform();

    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot(String name) {
        screenshotcount++;
        try {
            TakesScreenshot screenshot = (TakesScreenshot) wd;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\Acer\\Desktop\\Automation testing\\SS\\ACME\\SS" + name + screenshotcount + ".png");
            FileUtils.copyFile(srcFile, destFile);  // Save locally
            return FileUtils.readFileToByteArray(srcFile);  // Attach to Allure
        } catch (IOException e) {
            logger.info("Error occurred during taking Screenshot: " +e);
            e.printStackTrace();
            return null;
        }
    }

}
