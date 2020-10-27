package core.listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.ExtentReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{

    private ExtentTest test;
    private ExtentReports reports = ExtentReporter.getReportsObject();

    @Override
    public void onTestStart(ITestResult testResult)
    {
        test = reports.createTest(testResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult testResult)
    {
        test.log(Status.PASS,"The test passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult testResult)
    {
        test.fail(testResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {

    }

    @Override
    public void onStart(ITestContext testContext) {

    }

    @Override
    public void onFinish(ITestContext testContext) {
        reports.flush();
    }
}
