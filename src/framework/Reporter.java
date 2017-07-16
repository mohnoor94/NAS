package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import data.Data;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author AbuKhleif
 */
public class Reporter {
    private static Reporter reporter;
    private static DateFormat df = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
    private static String requiredDate = df.format(new Date());
    private static int failCounter;

    private static ExtentReports extent;
    private static ExtentTest currentTest;

    static {
        reporter = new Reporter();
        init();
        createTest("Test test", "No Desc.");
    }

    private Reporter() {
    }

    public static Reporter getInstance() {
        return reporter;
    }

    public static void init() {
        String title = Data.getData().get("title");
        String reportPath = "reports" + File.separator + Data.getData().get("file_name") + "-" + requiredDate + ".html";
        File report = new File(reportPath);
        if (!report.exists()) {
            // start reporters
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(report);

            // create ExtentReports and attach reporter(s)
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            setSystemInfo();

            // Configurations:
            configureReport(title, htmlReporter);
        }
    }

    private static void setSystemInfo() {
        extent.setSystemInfo("Tester", "AbuKhleif");
        extent.setSystemInfo("Environemnt", "intellij IDEA");
    }

    private static void configureReport(String title, ExtentHtmlReporter htmlReporter) {
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(title);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(title);
    }

    protected static void flush() {
        extent.flush();
    }

    public static void createTest(String testName, String description) {
        currentTest = extent.createTest(testName, description);
    }

    public static void log(Status status, String details) {
        currentTest.log(status, details);
    }


    /**
     * Report status of a message if it can be found in the page
     *
     * @param result
     * @param value
     */
    public void report(boolean result, boolean expected, String value) {
        if (expected) {
            if (result) {
                log(Status.PASS, "Value Founded: '" + value + "'");
            } else {
                log(Status.FAIL, "Value cannot be founded: '" + value + "'");
                ++failCounter;
            }
        } else {
            if (result) {
                log(Status.FAIL, "Value Founded: '" + value + "' but it should not!");
                ++failCounter;
            } else {
                log(Status.PASS, "Value '" + value + "' cannot be founded, as it should!");
            }
        }
    }

    /**
     * Report the equality of two messages
     *
     * @param result
     * @param actualValue
     * @param expectedValue
     */
    public void report(boolean result, boolean expected, String actualValue, String expectedValue) {
        if (expected) {
            if (result) {
                log(Status.PASS, "Actual value '" + actualValue + "' matches expected value");
            } else {
                log(Status.FAIL, "Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'");
                ++failCounter;
            }
        } else {
            if (result) {
                log(Status.FAIL, "Value '" + actualValue + "' founded, but it should not!");
                ++failCounter;
            } else {
                log(Status.PASS, "Value '" + actualValue + "' can not be founded, as it should!");
            }
        }
    }

    /**
     * get the current value of the failed tests counter.
     *
     * @return
     */
    public static int getFailCounter() {
        return failCounter;
    }

    /**
     * Reset the value of the failed tests counter.
     */
    public static void resetFailCounter() {
        failCounter = 0;
    }

    public static void reportError() {
        ++failCounter;
    }
}
