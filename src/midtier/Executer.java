package midtier;


import data.Data;
import framework.Base;
import framework.Driver;
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
public class Executer extends Base{
    private String filePath;
    private final String preFilePath = "./xml" + File.separator;
    private final String postFilePath = ".xml";
    private Driver driver;

    public void execute() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Unmarshaller um = context.createUnmarshaller();
        Site site = (Site) um.unmarshal(new FileReader(preFilePath + filePath + postFilePath));
        // Save file name to use it in report
        Data.getData().put("file_name", filePath);
        setUp(driver);
        site.parse();
        tearDown();
    }

    public void printData() {
        System.out.println("\nApp Data:");
        System.out.println(Collections.singletonList(Data.getData()));
        System.out.println("\nUser Data:");
        System.out.println(Collections.singletonList(Data.getUserData()));
    }


    public Executer(String filePath, Driver driver) {
        this.filePath = filePath;
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
}
