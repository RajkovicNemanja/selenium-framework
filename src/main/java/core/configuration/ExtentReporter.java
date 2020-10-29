package core.configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    private static ExtentReports reports;

    public static ExtentReports getReportsObject()
    {
        String path = System.getProperty("user.dir") + "\\reports\\html\\index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Regression tests report");
        sparkReporter.config().setDocumentTitle("Test results");

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("QA Engineer","Nemanja Rajkovic");
        return reports;
    }
}
