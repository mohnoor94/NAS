package test;

import action.*;
import data.Data;
import framework.Base;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;
import scope.unit.Page;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;

/**
 * @author AbuKhleif
 */
public class test extends Base {
    private static final String SITE_XML = "./site.xml";

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
//        Text text = new Text();
//        Page page = new Page();
//        Page page2 = new Page();
//
//        NotText notText1 = new NotText();
//        NotText notText2 = new NotText();
//        notText1.setValue("n1");
//        notText2.setValue("Enter your email address to get");
//
//        text.setValue("Enter your email address to get");
//
//        Site site = new Site();
//        site.setUrl("http://demo.guru99.com");
//
//        Store store = new Store("emailText","/html/body/form/table/tbody/tr[5]/td[1]");
//        ManualStore manualStore = new ManualStore("hello", "hi");
//        Scenario scenario = new Scenario();
//
//        page.getActions().add(text);
//        page.getActions().add(store);
//        page.getActions().add(manualStore);
//
//        page2.getActions().add(text);
//        page2.getActions().add(notText1);
//        page2.getActions().add(notText2);
//        page.getActions().add(notText2);
//
//
//        scenario.pages = new ArrayList<Page>();
//        scenario.pages.add(page);
//        scenario.pages.add(page2);
//
//        page.setName("Page 1");
//        page.setUrl("");
//        page2.setUrl("/hello");
//
//        site.getScenarios().add(scenario);

        Page ak = new Page("AbuKhleif", "http://abukhleif.com/", "no");
        Text akt1 = new Text("Latest stories");
        Text akt2 = new Text("Abu Khleif");
        ak.getActions().add(akt1);
        ak.getActions().add(akt2);

        Text t1 = new Text("Enter your email address to get");
        Text t2 = new Text("Access details to demo site.");
        NotText notFound = new NotText("Error 404");
        Text t3 = new Text("This access is valid only for 20 days.");
        Site site = new Site();
        site.setUrl("http://demo.guru99.com/");
        site.setName("Guru 99 Bank");
        Scenario scenario = new Scenario();

        site.getScenarios().add(scenario);

        scenario.setName("Login");
        Form form = new Form();
        scenario.getUnits().add(form);
        form.setName("Guru 99 bank Login");
        form.getActions().add(t1);
        form.getActions().add(notFound);
        FillElement fill = new FillElement("emailid", "email@example.com");

        form.getActions().add(fill);
//        Page page = new Page();
//        scenario.getUnits().add(page);
        Store username = new Store("username", "/html/body/table/tbody/tr[4]/td[2]");
        Store password = new Store("password", "/html/body/table/tbody/tr[5]/td[2]");
//        page.getActions().add(username);
//        page.getActions().add(password);

        Submit submit = new Submit("emailid");
        form.getActions().add(submit);

        form.getActions().add(t2);
        form.getActions().add(t3);
        form.getActions().add(notFound);

        form.getActions().add(username);
        form.getActions().add(password);

        ak.getActions().add(notFound);
        scenario.getUnits().add(ak);


        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(site, System.out);

        // Write to File
        m.marshal(site, new File(SITE_XML));


        // get variables from our xml file, created before
        System.out.println("=====================");
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Site site1 = (Site) um.unmarshal(new FileReader(
                SITE_XML));

        setUp();
        site1.parse();
        tearDown();

        System.out.println(Collections.singletonList(Data.getData()));
        System.out.println("\n\n\nUser Data:");
        System.out.println(Collections.singletonList(Data.getUserData()));

    }
}
