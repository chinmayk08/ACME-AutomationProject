package ACMEproject.Tests.LoginModule;

import ACMEproject.BusinessLib.Login;
import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;


public class LoginTestCases extends ExecutionDriver {

    public static final Logger logger= LogManager.getLogger(LoginTestCases.class);
    public static String ActualResult;
    public static String ExpectedResult;
    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));

    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK LOGIN SUCCESSFULLY")
    @Test(alwaysRun = true, priority = 1)
    public void checkloginsuccessfully() throws Exception {
        try {
            logger.info("running test case checkloginsuccessfully starts....");
            Login BrokerPageVisible = new Login(wd);
        ExpectedResult ="Dashboard";
        BrokerPageVisible.checkLoginSuccessfully();
        ActualResult = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginHeader)).getText();
        BrokerPageVisible.screenshot("checkloginsuccessfully");
        try{
            assertEquals(ActualResult, ExpectedResult, "The message displayed is not as expected.");
            logger.info("checkloginsuccessfully(priority = 2) test case passed");
        } catch (AssertionError e) {
            logger.error("checkloginsuccessfully(priority = 2) test case Failed..Expected: "+ExpectedResult+"Actual:"+ActualResult);
            throw e;
        }
        } catch (Exception e) {
            logger.error("Error occurred during checkloginsuccessfully test case..."+e);
        }
    }
}
