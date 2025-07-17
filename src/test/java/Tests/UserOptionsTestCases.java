package Tests;

import ACMEproject.BusinessLib.Login;
import ACMEproject.BusinessLib.UserOption;
import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import ACMEproject.Pages.UseroptionsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UserOptionsTestCases extends ExecutionDriver {
    public static final Logger logger= LogManager.getLogger(UserOptionsTestCases.class);
    public static String ActualResult;
    public static String ExpectedResult;
    public static UserOption useroption;
    public static Login login;

    @BeforeClass
    public void UserOptionsTestCasesSetup() throws IOException {
        login=new Login(wd);
        LoginPage.LogIn.click();
        login.checkLoginSuccessfully();
        useroption=new UserOption(wd);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK Download Client and Support Menu Open SUCCESSFULLY")
    @Test(alwaysRun = true, priority = 1)
    public void checkDownloadClientandSupportMenu() throws Exception {
        try {
            logger.info("running test case checkDownloadClientandSupportMenu starts....");
            ExpectedResult = "Download Client and Support";
            useroption.DownloadClientandSupportMenu();
            ActualResult = UseroptionsPage.pageHeader.getText();
            login.screenshot("checkDownloadClientandSupportMenu");
            try {
                assertEquals(ActualResult, ExpectedResult, "The message displayed is not as expected.");
                logger.info("checkDownloadClientandSupportMenu(priority = 1) test case passed");
            } catch (AssertionError e) {
                logger.error("checkDownloadClientandSupportMenu(priority = 1) test case Failed..Expected: " + ExpectedResult + "Actual:" + ActualResult);
                throw e;
            }
        } catch (Exception e) {
            logger.error("Error occurred during checkDownloadClientandSupportMenu test case..." + e);
        }
    }
}


