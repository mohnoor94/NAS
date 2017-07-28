package com.abukhleif.nas.midtier;

import com.abukhleif.nas.data.Data;
import com.abukhleif.nas.framework.Base;
import com.abukhleif.nas.framework.Driver;
import com.abukhleif.nas.framework.Reporter;
import com.abukhleif.nas.scope.Site;
import com.aventstack.extentreports.Status;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;

/**
 * A bridge class to connect the framework with xml based interface
 */
public class XMLBridge extends Bridge {
    {
        preFilePath = "." + File.separator + "xml" + File.separator;
        postFilePath = ".xml";
        // Create directories (folders) if not exists..
        File xml = new File("xml");
        File reports = new File("reports");
        if (!xml.exists()) {
            xml.mkdir();
        }
        if (!reports.exists()) {
            reports.mkdir();
        }
    }

    public XMLBridge(Site site, String fileName) {
        super(site, fileName);
    }

    public XMLBridge(Site site, String fileName, Driver driver) {
        super(site, fileName, driver);
    }

    public XMLBridge(Site site, String fileName, String title, Driver driver) {
        super(site, fileName, title, driver);
    }

    @Override
    public void write() throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to File
        String filePath = preFilePath + fileName + postFilePath;
        m.marshal(site, new File(filePath));
        System.out.println("XML file succesfully written to '" + filePath + "'");
    }

    @Override
    public void execute() {
        try {
            JAXBContext context = JAXBContext.newInstance(Site.class);
            Unmarshaller um = context.createUnmarshaller();
            Site site = (Site) um.unmarshal(new FileReader(preFilePath + fileName + postFilePath));
            // Save file name and title to use it in report
            Data.getData().put("file_name", fileName);
            Data.getData().put("title", getTitle());
            Base.setUp(driver);
            site.parse();
            Base.tearDown();
        } catch (Exception e) {
            Reporter.log(Status.FATAL, "While Executing Tests File, All Remaining Tests have been Skipped!\n" +
                    "Error Message from Executer: " + e.getMessage());
            Base.tearDown();
        }
    }
}
