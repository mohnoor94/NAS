package framework;

import java.util.List;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is copied (with minor changes) from Atypon automation framework.
 */
class DriverUtils {
    private static final boolean TRACE = false;

    private static WebElement getBy(WebDriver driver, By by) {

        try {
            WebElement elem = driver.findElement(by);
            return elem;
        } catch (Throwable ex) {
            // System.out.println("Could not find element : "+by+",
            // err:"+ex.toString());
            return null;
        }

    }

    static WebElement findElement(WebDriver driver, String identifier) {

        WebElement element = findElementByAll(driver, identifier);
        if (element == null) {
            element = findElementInsideFrames(driver, null, identifier);
        }
        if (element != null) {
            return element;
        }
        throw new RuntimeException("Element cannot be found using identifier (" + identifier + ")");
    }

    /**
     * Search for element inside the current opened web page
     *
     * @param driver
     * @param identifier
     */
    private static WebElement findElementByAll(WebDriver driver, String identifier) {
        WebElement element = getBy(driver, By.id(identifier));
        if (element == null) {
            element = getBy(driver, By.name(identifier));
        }
        if (element == null) {
            element = getBy(driver, By.xpath(identifier));
        }
        if (element == null) {
            element = getBy(driver, By.className(identifier));
        }
        if (element == null) {
            element = getBy(driver, By.linkText(identifier));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector(identifier));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector("a[title=\"" + identifier + "\"]"));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector("img[alt=\"" + identifier + "\"]"));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector("img[contains(@src\"" + identifier + "\"]"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//input[@alt='" + identifier + "']"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//input[@value='" + identifier + "']"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//input[@name='" + identifier + "']"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//input[@src='" + identifier + "']"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//input[@class='" + identifier + "']"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//img[contains(@src,'" + identifier + "')]"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//a[contains(@href,'" + identifier + "')]"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//a[contains(text(),'" + identifier + "')]"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//div[contains(text(),\"" + identifier + "\")]"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//label[contains(text(), \"" + identifier + "\")]"));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector("button[title=\"" + identifier + "\"]"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//div[@id='" + identifier + "']"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//div[contains(@id,'" + identifier + "')]"));
        }
        if (element == null) {
            element = getBy(driver, By.partialLinkText(identifier));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//img[contains(@alt,'" + identifier + "')]"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//span[contains(text(), \"" + identifier + "\")]"));
        }

        if (element == null) {
            element = getBy(driver, By.xpath("//span[@class='" + identifier + "']"));
        }
        if (element == null) {
            element = getBy(driver, By.xpath("//li[contains(text(), \"" + identifier + "\")]"));
        }
        if (element == null) {
            element = getBy(driver, By.cssSelector("'" + identifier + "'"));
        }

        return element;

    }

    /**
     * Search for element inside all frames in the current opened web page
     *
     * @param driver
     * @param findBy
     * @param identifier
     */
    private static WebElement findElementInsideFrames(WebDriver driver, By findBy, String identifier) {

        WebElement element = null;
        if (findBy == null && TextUtils.isEmpty(identifier)) {
            return element;
        }

        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
        if (iFrames.size() > 0) {
            if (TRACE) {
                System.out.println("Number of frames to search in " + iFrames.size());
            }
            String currentWindowHandler = driver.getWindowHandle();

            for (WebElement iFrame : iFrames) {
                if (TRACE) {
                    System.out.println("Searching in IFrame : " + iFrame);
                }
                driver.switchTo().frame(iFrame);
                try {
                    if (findBy == null) {
                        element = findElementByAll(driver, identifier);
                    } else {
                        element = getBy(driver, findBy);
                    }

                    if (TRACE && element == null) {
                        System.out.println("tag : " + element.getTagName() + ", visible : " + element.isDisplayed()
                                + ", content " + element.getText());
                    }
                    if (element != null) {
                        return element;
                    }
                } catch (NoSuchElementException me) {
                }
                driver.switchTo().window(currentWindowHandler);
            }
        }
        return element;
    }
}