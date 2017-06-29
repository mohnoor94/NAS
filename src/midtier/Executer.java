package midtier;


import data.Data;
import framework.Base;
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
    private final String preFilePath = "./xml" + File.separator;
    private final String postFilePath = ".xml";

    public void execute(String filePath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Unmarshaller um = context.createUnmarshaller();
        Site site = (Site) um.unmarshal(new FileReader(preFilePath + filePath + postFilePath));

        setUp();
        site.parse();
        tearDown();
    }

    public void execute() throws JAXBException, FileNotFoundException {
        execute("site");
    }

    public void printData() {
        System.out.println("\nApp Data:");
        System.out.println(Collections.singletonList(Data.getData()));
        System.out.println("\nUser Data:");
        System.out.println(Collections.singletonList(Data.getUserData()));
    }

    public Executer() {
    }

    public Executer(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
