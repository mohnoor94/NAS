package midtier;


import com.aventstack.extentreports.Status;
import data.Data;
import framework.Base;
import framework.Driver;
import framework.Reporter;
import scope.Site;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;

/**
 * This class responsibility is to execute xml files (qa tests)
 *
 * @author AbuKhleif
 */
public class Executer extends Base {
    private String filePath;
    private String title = null;
    private final String preFilePath = "./xml" + File.separator;
    private final String postFilePath = ".xml";
    private Driver driver;

    public void execute() {
        try {
            JAXBContext context = JAXBContext.newInstance(Site.class);
            Unmarshaller um = context.createUnmarshaller();
            Site site = (Site) um.unmarshal(new FileReader(preFilePath + filePath + postFilePath));
            // Save file name to use it in report
            Data.getData().put("file_name", filePath);
            Data.getData().put("title", getTitle());
            setUp(driver);
            site.parse();
            tearDown();
        } catch (Exception e) {
            Reporter.log(Status.FATAL, "While Executing Tests File, All Remaining Tests have been Skipped!\n" +
                    "Error Message from Executer: " + e.getMessage());
            tearDown();
        }
    }

    public void printData() {
        System.out.println("\nApp Data:");
        System.out.println(Collections.singletonList(Data.getData()));
        System.out.println("\nUser Data:");
        System.out.println(Collections.singletonList(Data.getUserData()));
        System.out.println("\nScenarios Status:");
        System.out.println(Collections.singletonList(Data.getScenariosStatus()));
    }


    public Executer(String filePath, Driver driver) {
        this.filePath = filePath;
        this.driver = driver;
    }

    public Executer(String filePath, String title, Driver driver) {
        this.filePath = filePath;
        this.title = title;
        this.driver = driver;
    }

    public Executer(String filePath) {
        // default browser: chrome...
        this.driver = Driver.CHROME;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTitle() {
        if (title == null) {
            title = filePath;
        }
        return title;
    }
}
