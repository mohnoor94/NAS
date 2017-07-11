package test;

import action.VerifyText;
import action.custom.Custom;
import framework.Base;
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
public class WriterTester_CustomModules3 extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #3"));
        writer.addForm(new Form("Search Page", ""));
        writer.addAction(new VerifyText("الأردن"));
        writer.setCustom(new Custom("ThirdModularCustomCode"));
        writer.addVariable("String","url","http://www.abukhleif.com/");
        writer.addVariable("String", "text", "Latest stories");
        writer.addVariable("String", "notText", "Page not found");
        writer.addMethod("navigateAndVerify", "navigate(url);\n" +
                "            verify(text, true);\n" +
                "            verify(notText, false);");
        writer.commitCustomAction();
        writer.write("custom_modules3");
    }
}
