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
public class WriterTester_CustomModules2 extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #2 - Contains Invalid Variable Type!"));
        writer.addForm(new Form("Search Page", ""));
        writer.addAction(new VerifyText("الأردن"));
        writer.setCustom(new Custom("SecondModularCustomCode"));
        writer.addVariable("integer","x","5");
        writer.addMethod("printer", "System.out.println(x);");
        writer.commitCustomAction();
        writer.write("custom_modules2");
    }
}
