package ACMEproject.Utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String message = "Test case " + testName + " failed.";
        EmailUtil.sendEmail("Test Failure Notification", message);
    }

    // You can override other methods if needed
}