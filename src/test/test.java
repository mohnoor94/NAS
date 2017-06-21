package test;

import action.Click;
import action.NotText;
import framework.Base;
import scope.Data;
import scope.Page;
import scope.Scenario;
import action.Text;
import scope.Site;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mkhlif on 6/20/17.
 */
public class test extends Base {
    private static final String SITE_XML = "./site.xml";


    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Click c1 = new Click();
        Click c2 = new Click();
        Click c3 = new Click();
        Text text = new Text();
        Page page = new Page();
        Page page2 = new Page();

        NotText notText1 = new NotText();
        NotText notText2 = new NotText();
        notText1.setValue("n1");
        notText2.setValue("n2");

        text.setValue("Enter your email address to get");
//        c1.setId("sdfakljas");
//        c2.setId("zdf");
//        c3.setId("asd");

        Site site = new Site();
        site.setUrl("http://demo.guru99.com/");

        Scenario scenario = new Scenario();

        page.getActions().add(text);

//        page.navigate = new ArrayList<Click>();
//        page.navigate.add(c1);
//        page.navigate.add(c2);
//

        page2.getActions().add(text);
        page2.getActions().add(notText1);
        page2.getActions().add(notText2);
//
//        page2.navigate = new ArrayList<Click>();
//        page2.navigate.add(c1);
//        page2.navigate.add(c3);
//        page2.navigate.add(c2);

        scenario.pages = new ArrayList<Page>();
        scenario.pages.add(page);
        scenario.pages.add(page2);

        page.setName("Page 1");
        page.setUrl("url");
        page2.setUrl("url2");

        site.getScenarios().add(scenario);


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
    }
}
