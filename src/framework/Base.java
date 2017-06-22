package framework;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.security.SecureRandom;
import java.util.List;

/**
 * General operations needed by tests
 *
 * @author AbuKhleif
 */
public class Base extends Reportable {
    DriverUtils driverUtils = new DriverUtils();
    private static WebDriver driver;

    /**
     * Before all tests
     *
     * @throws Exception
     */
    protected static void setUp() {
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
    protected static void tearDown() {
        // write report results
        writeResults();

        // quit the browser
        driver.quit();
    }

    /**
     * If (find) test if the page contains a certain sentence,
     * otherwise test if it's not contain it
     *
     * @param messgae
     * @param find
     */
    protected void verify(String messgae, boolean find) {
        report(isPageContains(messgae), find, messgae);
    }

    /**
     * If (find) test equality of two sentences,
     * otherwise test if they are not equal
     * @param message1
     * @param message2
     * @param find
     */
    protected void verify(String message1, String message2, boolean find) {
        report(message1.equals(message2), find, message1, message2);
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

        // My Solution
//        int trial = 4;
//        while (--trial != 0) {
//            try {
//                if (trial == 3) {
//                    element = findElementById(key);
//                    break;
//                } else if (trial == 2) {
//                    element = findElementByName(key);
//                    break;
//                } else if (trial == 1) {
//                    element = findElementByXPath(key);
//                    break;
//                }
//            } catch (NoSuchElementException e) {
//                // continue;
//            }
//        }
//        // TODO add other cases..
//        return element;

        return DriverUtils.findElement(driver, key);
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
     * navigate to any link (click link on page, if not found go to url)
     *
     * @param key id, name, or xpath of webElement
     */
    protected void navigate(String key) {
        try {
            findElement(key).click();
        } catch (Exception e) {
            driver.get(key);
        }
    }

    /**
     * TODO UPDATE ME!
     * navigate checkbox by index
     * Currently support find webElements just by name
     *
     * @param webElementKey id, name, or xpath of webElement
     * @param index         of action to select
     */
    protected void clickCheckbox(String webElementKey, int index) {
        List<WebElement> elements = findElementsByName(webElementKey);
        elements.get(index).click();
    }

    /**
     * TODO UPDATE ME!
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
