package Tests;

import ACMEproject.BusinessLib.Login;
import ACMEproject.BusinessLib.UserOption;
import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import ACMEproject.Pages.UseroptionsPage;
import ACMEproject.Utility.FileHandling;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ACMEproject.Utility.FileHandling.isfiledownload;
import static org.testng.Assert.assertEquals;

public class UserOptionsTestCases extends ExecutionDriver {
    public static final Logger logger= LogManager.getLogger(UserOptionsTestCases.class);
    public static String ActualResult;
    public static String ExpectedResult;
    public static UserOption useroption;
    public static Login login;
    public UseroptionsPage UseroptionsPage;

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

    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK LEGACY SYSTEM DOWNLOAD SUCCESSFULLY")
    @Test(alwaysRun = true, priority = 2)
    public void CheckDownloadLegacySystemreport() throws Exception {
        try {
            logger.info("running test case CheckDownloadLegacySystemreport starts....");
            boolean ExpectedResult =true;
            String downloadPath = "C:\\Users\\Acer\\Downloads\\";
            String expectedFile = "ACME-System3-v0.1.zip";
            useroption.DownloadLegacySystemreport();
            boolean isDownloaded = isfiledownload(downloadPath, expectedFile);
            boolean ActualResult =isDownloaded;
            login.screenshot("CheckDownloadLegacySystemreport");
            try {
                assertEquals(ActualResult, ExpectedResult, "The message displayed is not as expected.");
                logger.info("CheckDownloadLegacySystemreport(priority = 2) test case passed");
            } catch (AssertionError e) {
                logger.error("CheckDownloadLegacySystemreport(priority = 2) test case Failed..Expected: " + ExpectedResult + "Actual:" + ActualResult);
                throw e;
            }
        } catch (Exception e) {
            logger.error("Error occurred during CheckDownloadLegacySystemreport test case..." + e);
        }
    }




}


