package samples;

import action.Note;
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
public class WriterTester_Custom5_Interface extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("localhost", "http://localhost/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #5"));
        writer.setScenarioDescription("This scenario includes Interface and SuperClass inherited, " +
                        "and import statement with the CustomCode!");
        writer.addForm(new Form("Localhost", ""));
        writer.addAction(new Note("No steps actually tested here, you can check the Java console output.<br>This is" +
                " just an example to show the ability of implement Java interfaces.<br>" +
                "Note: you can implement many interfaces (but 'at least currently' you can't override their methods"));
        // You HAVE TO 'setCustom(...)' Acton, add members (imports, extend, implements),
        // then commit your action with 'commitCustomAction()'
        writer.setCustom(new Custom("CustomSuperClass", "System.out.println(\"I'm just an example, you can extend any other class..\");"));
        writer.extend("Object");
        writer.implement("Serializable");
        writer.addImport("java.io.Serializable");
        writer.commitCustomAction();
        writer.write("custom_script5");
    }
}
