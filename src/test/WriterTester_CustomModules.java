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
public class WriterTester_CustomModules extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #1 - Contain simple method and variable" +
                " (result printed on the console just for testing purposes)."));
        writer.addForm(new Form("Search Page", ""));
        writer.addAction(new VerifyText("الأردن"));
        // set the action if you want to specify the title..
        writer.setCustom(new Custom("FirstModularCustomCode"));
        writer.addVariable("int","x","5");
        writer.addMethod("printer", "System.out.println(x);");
        // Custom Action with methods and variables needs to be committed after adding all its members...
        writer.commitCustomAction();
        writer.write("custom_modules");
    }
}
