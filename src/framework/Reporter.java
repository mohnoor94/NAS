package framework;

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
    private static String reportPath;

    static {
        reporter = new Reporter();
    }

    private Reporter() {
    }

    public static Reporter getInstance() {
        return reporter;
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
                writeResult(new TestResult("Passed", "Value Founded: '" + value + "'"));
            } else {
                writeResult(new TestResult("Failed", "Value cannot be founded: '" + value + "'"));
            }
        } else {
            if (result) {
                writeResult(new TestResult("Failed", "Value Founded: '" + value + "' but it should not!"));
            } else {
                writeResult(new TestResult("Passed", "Value '" + value + "' cannot be founded, as it should!"));
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
                writeResult(new TestResult("Passed", "Actual value '" + actualValue + "' matches expected value"));
            } else {
                writeResult(new TestResult("Failed", "Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'"));
            }
        } else {
            if (result) {
                writeResult(new TestResult("Failed", "Value '" + actualValue + "' founded, but it should not!"));
            } else {
                writeResult(new TestResult("Passed", "Value '" + actualValue + "' can not be founded, as it should!"));
            }
        }
    }

    /**
     * Add header to report
     *
     * @param type        site or scenario
     * @param description text to be shown
     */
    public void addHeader(String type, String description) {
        writeResult(new TestResult(type, description));
    }

    /**
     * Add header to report
     *
     * @param type        site or scenario
     * @param description text to be shown
     */
    public void addFooter(String type, String description) {
        if ("site".equals(type.toLowerCase())) {
            type = "site_end";
        } else if ("scenario".equals(type.toLowerCase())) {
            type = "scenario_end";
        } else if ("page".equals(type.toLowerCase())) {
            type = "page_end";
        } else if ("form".equals(type.toLowerCase())) {
            type = "form_end";
        } else if ("custom".equals(type.toLowerCase())) {
            type = "custom_end";
        }
        writeResult(new TestResult(type, description));
    }

    public static void writeReportHeader() {
        reportPath = "reports" + File.separator + Data.getData().get("file_name") + "-" + requiredDate + ".html";
        File report = new File(reportPath);
        if (!report.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("resources" + File.separator + "report_header.html"));
                 PrintWriter writer = new PrintWriter(new FileWriter(report, true), true)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error writing report!!! --> " + e);
            }
        }
    }

    protected static void writeReportFooter() {
        File report = new File(reportPath);
        try (BufferedReader reader = new BufferedReader(new FileReader("resources" + File.separator + "report_footer.html"));
             PrintWriter writer = new PrintWriter(new FileWriter(report, true), true)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error writing report!!! --> " + e);
        }
        System.out.println("Report succesfully written to \'" + reportPath + "\'");
    }


    /**
     * Write report results
     */

    private static int i = 1;

    private static void writeResult(TestResult result) {
        File report = new File(reportPath);
        try (PrintWriter writer = new PrintWriter(new FileWriter(report, true), true)
        ) {
            switch (result.getResult().toLowerCase()) {
                case "passed":
                    writer.println("<tr><td>" + Integer.toString(i++) + "<td>" + result.getDescription() + "</td><td class=\"passed\">" + result.getResult() + "</td></tr>");
                    break;
                case "failed":
                    writer.println("<tr><td>" + Integer.toString(i++) + "<td>" + result.getDescription() + "</td><td class=\"failed\">" + result.getResult() + "</td></tr>");
                    break;
                case "site":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"site\" colspan=\"2\">Enter Site: " + result.getDescription() + "</td></tr>");
                    break;
                case "scenario":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"scenario\" colspan=\"2\">Start Scenario: " + result.getDescription() + "</td></tr>");
                    break;
                case "page":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"page\" colspan=\"2\">Enter Page: " + result.getDescription() + "</td></tr>");
                    break;
                case "form":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"form\" colspan=\"2\">Enter Form: " + result.getDescription() + "</td></tr>");
                    break;
                case "custom":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"custom\" colspan=\"2\">" + result.getDescription() + "</td></tr>");
                    break;
                case "click":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"click\" colspan=\"2\">Click: " + result.getDescription() + "</td></tr>");
                    break;
                case "submit":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"submit\" colspan=\"2\">Submit Form " + result.getDescription() + "</td></tr>");
                    break;
                case "site_end":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Site: " + result.getDescription() + "</td></tr>");
                    break;
                case "scenario_end":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"end\" colspan=\"2\">End Scenario: " + result.getDescription() + "</td></tr>");
                    break;
                case "page_end":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Page: " + result.getDescription() + "</td></tr>");
                    break;
                case "form_end":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Form: " + result.getDescription() + "</td></tr>");
                    break;
                case "custom_end":
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td>" + "<td class=\"custom_end\" colspan=\"2\">" + result.getDescription() + "</td></tr>");
                    break;
                case "error":
                    writer.println("<tr><td class=\"error\" colspan=\"3\">ERROR: " + result.getDescription() + "</td></tr>");
                    break;
                default:
                    writer.println("<tr><td>" + Integer.toString(i++) + "</td><td>" + result.getResult() + "</td><td>" + result.getDescription() + "</td></tr>");
            }
        } catch (IOException e) {
            System.out.println("Error writing report!!! --> " + e);
        }
    }
}
