package framework;

import test.TestResult;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mkhlif on 6/21/17.
 */
public class Reportable {
    private static List<TestResult> results = new ArrayList<TestResult>();


    /**
     * Report status of a message if it can be found in the page
     *
     * @param result
     * @param value
     */
    protected void report(boolean result, boolean expected, String value) {
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
    protected void report(boolean result, boolean expected, String actualValue, String expectedValue) {
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
     * Write report results
     */
    protected static void writeResults() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String requiredDate = df.format(new Date());
        File report = new File("results" + File.separator + "report_" + requiredDate + ".html");
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
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getResult().equals("Passed")) {
                    writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td> <font color=\"green\">" + results.get(i).getResult() +
                            "</font> </td><td>" + results.get(i).getDescription() + "</td></tr>");
                } else {
                    writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td> <font color=\"red\"><strong>" +
                            results.get(i).getResult() +
                            " </strong> </font></td><td>" + results.get(i).getDescription() + "</td></tr>");
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
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
