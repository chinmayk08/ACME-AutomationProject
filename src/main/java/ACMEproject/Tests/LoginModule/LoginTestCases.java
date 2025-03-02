package ACMEproject.Tests.LoginModule;

import ACMEproject.BusinessLib.Login;
import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import static org.testng.Assert.assertEquals;


public class LoginTestCases extends ExecutionDriver {
    public static final Logger logger= LogManager.getLogger(LoginTestCases.class);
    public static String ActualResult;
    public static String ExpectedResult;
    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
    public static Login login;

    @BeforeClass
    public void setuptest() throws IOException {
        login=new Login(wd);
        LoginPage.LogIn.click();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK LOGIN SUCCESSFULLY")
    @Test(alwaysRun = true, priority = 1)
    public void checkloginsuccessfully() throws Exception {
        try {
            logger.info("running test case checkloginsuccessfully starts....");
            ExpectedResult ="Dashboard";
            login.checkLoginSuccessfully();
            ActualResult = wait.until(ExpectedConditions.visibilityOf(LoginPage.loginHeader)).getText();
            login.screenshot("checkloginsuccessfully");
        try{
            assertEquals(ActualResult, ExpectedResult, "The message displayed is not as expected.");
            logger.info("checkloginsuccessfully(priority = 1) test case passed");
        } catch (AssertionError e) {
            logger.error("checkloginsuccessfully(priority = 1) test case Failed..Expected: "+ExpectedResult+"Actual:"+ActualResult);
            throw e;
        }
        } catch (Exception e) {
            logger.error("Error occurred during checkloginsuccessfully test case..."+e);
        }
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK INVALID LOGIN CREDENTIALS")
    @Test(priority = 2,alwaysRun = true)
    public void checkInvalidLoginCred(){
        try {
            logger.info("running test case checkInvalidLoginCred starts....");
            ExpectedResult="Login";
            login.checkLoginwithInvalidcred();
            ActualResult=wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginHeader)).getText();
            login.screenshot("checkInvalidLoginCred");
            try{
                assertEquals(ActualResult, ExpectedResult, "The Result is not as expected.");
                logger.info("checkInvalidLoginCred(priority = 2) test case passed");
            } catch (AssertionError e) {
                logger.error("checkInvalidLoginCred(priority = 2) test case Failed..Expected: "+ExpectedResult+"Actual:"+ActualResult);
                throw e;
            }
        }
        catch (Exception e){
            logger.error("Error occurred during checkInvalidLoginCred Test(priority = 2):"+e);
        }
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK REGISTRATION FORM FILL")
    @Test(priority = 3,alwaysRun = true)
    public void checkRegisrtation(){
        try {
            // check email not register without captcha
            logger.info("running test case checkRegisrtation starts....");
            ExpectedResult="Register";
            login.RegisterEmail();
            ActualResult=wait.until(ExpectedConditions.visibilityOf(LoginPage.RegisterHeader)).getText();
            login.screenshot("checkRegisrtation");
            try{
                assertEquals(ActualResult, ExpectedResult, "The Result is not as expected.");
                logger.info("checkRegisrtation(priority = 3) test case passed");
            } catch (AssertionError e) {
                logger.error("checkRegisrtation(priority = 3) test case Failed..Expected: "+ExpectedResult+"Actual:"+ActualResult);
                throw e;
            }
        }
        catch (Exception e){
            logger.error("Error occurred during checkRegisrtation Test(priority = 3):"+e);
        }
    }

}
