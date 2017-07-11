package test;

import action.VerifyText;
import action.custom.Custom;
import framework.Base;
import framework.Reporter;
import midtier.Writer;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;

import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 *
 * @author AbuKhleif
 */
public class WriterTester_CustomModules4 extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #4 - Multiple Methods"));
        writer.addForm(new Form("Search Page", ""));
        writer.addAction(new VerifyText("الأردن"));
        writer.setCustom(new Custom("FourthModularCustomCode"));
        writer.addVariable("String", "url", "http://www.abukhleif.com/");
        writer.addVariable("String", "text", "Latest stories");
        writer.addVariable("String", "notText", "Page not found");
        writer.addVariable("String", "value", "Hello World");
        writer.addMethod("navigateAndVerify", "navigate(url);\n" +
                "            verify(text, true);\n" +
                "            verify(notText, false);");
        writer.addMethod("printToConsole", "System.out.println(value);");
        writer.setPackage("action.custom");
        writer.commitCustomAction();
        writer.write("custom_modules4");
    }
}
