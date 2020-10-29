package core.listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.configuration.ExtentReporter;
import core.configuration.Screenshots;
import org.openqa.selenium.WebDriver;
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
        test = reports.createTest(getTestCaseMethodName(testResult));
    }

    @Override
    public void onTestSuccess(ITestResult testResult)
    {
        test.log(Status.PASS,"The test passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult testResult)
    {
        final Screenshots screenshots = new Screenshots();
        final WebDriver driver = getWebDriverInstanceForTheCurrentTest(testResult);
        final String testCaseMethodName = getTestCaseMethodName(testResult);
        //creates screenshots and stores it on predefined location
        screenshots.getScreenshotPath(driver, testCaseMethodName);

        test.fail(testResult.getThrowable());
        test.addScreenCaptureFromPath("..\\screenshots\\"+testCaseMethodName+".png", testCaseMethodName);

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

    private String getTestCaseMethodName(final ITestResult testResult)
    {
        return testResult.getMethod().getMethodName();
    }

    private WebDriver getWebDriverInstanceForTheCurrentTest(final ITestResult testResult)
    {
        //TODO: get property from the method, not directly
        try {
            return (WebDriver) testResult.getTestClass()
                    .getRealClass()
                    .getSuperclass()
                    .getMethod("getDriver",null)
                    .invoke( testResult.getInstance(),null );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
