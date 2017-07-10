package test;

import action.*;
import midtier.Writer;
import scope.Scenario;
import scope.Site;
import scope.unit.Page;

import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 *
 * @author AbuKhleif
 */
public class WriterTester_AbuKhleif {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("AbuKhleif", "http://www.abukhleif.com"));
        writer.addScenario(new Scenario("AbuKhleif Website Discovering"));
        writer.addPage(new Page("Main Page", ""));
        writer.addAction(new VerifyText("Latest stories"));
        writer.addAction(new VerifyNotText("Error 404"));
        writer.addPage(new Page("Get Free Windows 10", "windows10-and-more-free-students"));
        writer.addAction(new VerifyText("onthehub"));
        writer.addAction(new VerifyText("البحث عن جامعتك"));
        writer.write("abukhleif");
    }
}
