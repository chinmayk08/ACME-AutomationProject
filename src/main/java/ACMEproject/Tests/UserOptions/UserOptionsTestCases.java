package ACMEproject.Tests.UserOptions;

import ACMEproject.BusinessLib.Login;
import ACMEproject.BusinessLib.UserOption;
import ACMEproject.Framework.ExecutionDriver;
import ACMEproject.Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UserOptionsTestCases extends ExecutionDriver {
    public static final Logger logger= LogManager.getLogger(UserOptionsTestCases.class);
    public static String ActualResult;
    public static String ExpectedResult;
    public static UserOption useroption;

    @BeforeClass
    public void UserOptionsTestCases(WebDriver wd) throws IOException {
        useroption=new UserOption(wd);
        this.wd=wd;
        LoginPage.LogIn.click();

    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("CHECK LOGIN SUCCESSFULLY")
    @Test(alwaysRun = true, priority = 1)
    public void checkDownloadClientandSupport() throws Exception {


    }
}


