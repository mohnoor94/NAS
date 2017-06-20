package framework;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import test.TestResult;

import java.io.*;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * General operations needed by tests
 *
 * @author AbuKhleif
 */
public class Base {
    private List<TestResult> results = new ArrayList<TestResult>();
    private WebDriver driver;

    /**
     * Before all tests
     *
     * @throws Exception
     */
    protected void setUp() {
        // select driver
        if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        }
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    /**
     * After all tests
     *
     * @throws Exception
     */
    protected void tearDown() {
        // write report results
        writeResults();

        // quit the browser
        driver.quit();
    }

    /**
     * Open url
     *
     * @param url
     */
    protected void openURL(String url) {
        driver.get(url);
    }

    /**
     * Test if the page contains a certain sentence
     *
     * @param messgae
     */
    protected void verify(String messgae) {
        report(isPageContains(messgae), messgae);
    }

    /**
     * Test equality of two sentences
     *
     * @param message1
     * @param message2
     */
    protected void verify(String message1, String message2) {
        report(message1.equals(message2), message1, message2);
    }

    /**
     * Find action by id, name, or xpath
     *
     * @param key
     * @return WebElement
     */
    private WebElement findElement(String key) {
        WebElement element = null;
//        if ((action = findElementById(key)) != null){
//            return action;
//        } else if ((action = findElementByName(key)) != null){
//            return action;
//        } else if ((action = findElementByXPath(key)) != null){
//            return action;
//        }
//    // Exceptions can be thrown...
        int trial = 4;
        while (--trial != 0) {
            try {
                if (trial == 3) {
                    element = findElementById(key);
                    break;
                } else if (trial == 2) {
                    element = findElementByName(key);
                    break;
                } else if (trial == 1) {
                    element = findElementByXPath(key);
                    break;
                }
            } catch (NoSuchElementException e) {
                // continue;
            }
        }
        // TODO add other cases..
        return element;
    }

    /**
     * Fill any webElement with a value
     *
     * @param elementKey
     * @param value
     */
    protected void fillElement(String elementKey, String value) {
        fillElement(findElement(elementKey), value);
    }

    /**
     * Get text of an webElement
     *
     * @param webElementKey id, name, or xpath of webElement
     * @return text of the action
     */
    protected String getText(String webElementKey) {
        return findElement(webElementKey).getText();
    }

    /**
     * submit form via any webElement
     *
     * @param webElementKey id, name, or xpath of webElement
     */
    protected void submit(String webElementKey) {
        findElement(webElementKey).submit();
    }

    /**
     * click any link
     *
     * @param webElementKey id, name, or xpath of webElement
     */
    protected void click(String webElementKey) {
        findElement(webElementKey).click();
    }

    /**
     * UPDATE ME!
     * click checkbox by index
     * Currently support find webElements just by name
     *
     * @param webElementKey id, name, or xpath of webElement
     * @param index         of action to select
     */
    protected void click(String webElementKey, int index) {
        List<WebElement> elements = findElementsByName(webElementKey);
        elements.get(index).click();
    }

    /**
     * UPDATE ME!
     * select value from dropdown menu
     * Currently support selection by visible text only
     *
     * @param webElementKey
     * @param visibleText
     */
    protected void select(String webElementKey, String visibleText) {
        WebElement element = findElement(webElementKey);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Find webElement by its name
     *
     * @param name
     * @return WebElement
     */
    private WebElement findElementByName(String name) {
        return driver.findElement(By.name(name));
    }

    /**
     * Find webElement by its id
     *
     * @param id
     * @return WebElement
     */
    private WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    /**
     * Find webElement by its XPath
     *
     * @param xpath
     * @return WebElement
     */
    private WebElement findElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Find webElements by name
     *
     * @param name
     * @return List<WebElement>
     */
    private List findElementsByName(String name) {
        return driver.findElements(By.name(name));
    }

    /**
     * Fill webElement with a value
     *
     * @param elementKey
     * @param value
     */
    private void fillElement(WebElement elementKey, String value) {
        elementKey.sendKeys(value);
    }

    /**
     * check if the page contains a certain sentence
     *
     * @param text
     * @return boolean
     */
    private boolean isPageContains(String text) {
        return driver.getPageSource().contains(text);
    }


    /**
     * Respond to alert
     *
     * @param accept accept alert if true, dismiss otherwise
     */
    protected void respondAlert(boolean accept) {
        if (accept)
            driver.switchTo().alert().accept();
        else
            driver.switchTo().alert().dismiss();
    }

    /**
     * @return String text of the alert
     */
    protected String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Report status of a message if it can be found in the page
     *
     * @param result
     * @param value
     */
    private void report(boolean result, String value) {
        if (result) {
            results.add(new TestResult("Passed", "Value Founded: '" + value + "'"));
        } else {
            results.add(new TestResult("Failed", "Value cannot be founded: '" + value + "'"));
        }
    }

    /**
     * Report the equality of two messages
     *
     * @param result
     * @param actualValue
     * @param expectedValue
     */
    private void report(boolean result, String actualValue, String expectedValue) {
        if (result) {
            results.add(new TestResult("Passed", "Actual value '" + actualValue + "' matches expected value"));
        } else {
            results.add(new TestResult("Failed", "Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'"));
        }
    }

    /**
     * Write report results
     */
    private void writeResults() {
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
                    writer.println("<tr><td>" + Integer.toString(i + 1) + "</td><td>" + results.get(i).getResult() +
                            "</td><td>" + results.get(i).getDescription() + "</td></tr>");
                } else {
                    writer.println("<tr><td> <font color=\"red\">" + Integer.toString(i + 1) + "</font> </td><td> <font color=\"red\"><strong>" +
                            results.get(i).getResult() +
                            " <strong> </font></td><td> <font color=\"red\">" + results.get(i).getDescription() + "</font></td></tr>");
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

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    /**
     * Generate a random email
     *
     * @return String email
     */
    protected String generateRandomEmail() {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        sb.append("@example.com");
        return sb.toString();
    }
}
