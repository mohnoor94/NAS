package test;

import action.*;
import framework.Base;
import midtier.Writer;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;
import scope.unit.Page;

import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 *
 * @author AbuKhleif
 */
public class WriterTester_Custom extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Guru", "http://demo.guru99.com/"));
        writer.addScenario(new Scenario("Custom Code Injection!"));
        writer.addPage(new Page("Main Page", ""));

        StringBuilder sb = new StringBuilder();
        sb.append("verify(\"Enter your email address to get\",true);\n");
        sb.append("verify(\"access details to demo site\",true);\n");

        writer.addAction(new Custom(sb.toString()));
        writer.write("custom");

    }
}
