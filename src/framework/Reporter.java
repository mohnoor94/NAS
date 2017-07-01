package framework;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AbuKhleif
 */
public class Reporter {
    private static List<TestResult> results = new ArrayList<TestResult>();
    private static Reporter reporter;

    static {
        reporter = new Reporter();
    }
    private Reporter() {
    }
    public static Reporter getInstance(){
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
                results.add(new TestResult("Passed", "Value Founded: '" + value + "'"));
            } else {
                results.add(new TestResult("Failed", "Value cannot be founded: '" + value + "'"));
            }
        } else {
            if (result) {
                results.add(new TestResult("Failed", "Value Founded: '" + value + "' but it should not!"));
            } else {
                results.add(new TestResult("Passed", "Value '" + value + "' cannot be founded, as it should!"));
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
                results.add(new TestResult("Passed", "Actual value '" + actualValue + "' matches expected value"));
            } else {
                results.add(new TestResult("Failed", "Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'"));
            }
        } else {
            if (result) {
                results.add(new TestResult("Failed", "Value '" + actualValue + "' founded, but it should not!"));
            } else {
                results.add(new TestResult("Passed", "Value '" + actualValue + "' can not be founded, as it should!"));
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
        results.add(new TestResult(type, description));
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
        }
        results.add(new TestResult(type, description));
    }


    /**
     * Write report results
     */
    static void writeResults() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String requiredDate = df.format(new Date());
        File report = new File("reports" + File.separator + "report_" + requiredDate + ".html");
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("resources" + File.separator + "report_header.html"));
            writer = new PrintWriter(new FileWriter(report));

            // Report header
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            // Report Contents
            // TODO edit <h?> and <font>
            for (int i = 0; i < results.size(); i++) {
                switch (results.get(i).getResult().toLowerCase()) {
                    case "passed":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td class=\"passed\">" + results.get(i).getResult() + "</td><td>" + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "failed":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td class=\"failed\">" + results.get(i).getResult() + "</td><td>" + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "site":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"site\" colspan=\"2\">Enter Site: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "scenario":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"scenario\" colspan=\"2\">Start Scenario: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "page":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"page\" colspan=\"2\">Enter Page: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "form":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"form\" colspan=\"2\">Enter Form: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "site_end":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Site: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "scenario_end":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"end\" colspan=\"2\">End Scenario: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "page_end":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Page: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    case "form_end":
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td>" + "<td class=\"end\" colspan=\"2\">Leave Form: " + results.get(i).getDescription() + "</td></tr>");
                        break;
                    default:
                        writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td>" + results.get(i).getResult() + "</td><td>" + results.get(i).getDescription() + "</td></tr>");
                }
            }

            // Report Footer
            reader = new BufferedReader(new FileReader("resources" + File.separator + "report_footer.html"));
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
