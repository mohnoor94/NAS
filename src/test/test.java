package test;

import action.Click;
import scope.Page;
import scope.Scenario;
import action.Text;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by mkhlif on 6/20/17.
 */
public class test {
    private static final String SCENARIO_XML = "./scenario-jaxb.xml";


    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Click c1 = new Click();
        Click c2 = new Click();
        Click c3 = new Click();
        Text text = new Text();
        Page page = new Page();
        Page page2 = new Page();

//        text.setValue("hello");
//        c1.setId("sdfakljas");
//        c2.setId("zdf");
//        c3.setId("asd");

        Scenario scenario = new Scenario();
//        page.text = new ArrayList<Text>();
//        page.text.add(text);
//
//        page.navigate = new ArrayList<Click>();
//        page.navigate.add(c1);
//        page.navigate.add(c2);
//
//        page2.text = new ArrayList<Text>();
//        page2.text.add(text);
//
//        page2.navigate = new ArrayList<Click>();
//        page2.navigate.add(c1);
//        page2.navigate.add(c3);
//        page2.navigate.add(c2);

        scenario.pages = new ArrayList<Page>();
        scenario.pages.add(page);
        scenario.pages.add(page2);


        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(scenario, System.out);

        // Write to File
        m.marshal(scenario, new File(SCENARIO_XML));


        // get variables from our xml file, created before
        System.out.println("=====================");
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Scenario scenario2 = (Scenario) um.unmarshal(new FileReader(
                SCENARIO_XML));
        scenario2.parse();
//        ArrayList<Page> pages = scenario2.getPages();
//        for (Page p : pages) {
//            ArrayList<Text> texts = p.getText();
//            for (Text t: texts){
//                System.out.println(t+" --> "+t.getValue());
//            }
//            ArrayList<Click> clicks = p.getClick();
//            for (Click c: clicks){
//                System.out.println(c+" --> "+c.getId());
//            }
//        }
    }
}
