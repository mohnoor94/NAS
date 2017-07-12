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
public class WriterTester_Custom4_SuperClass extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("localhost", "http://localhost/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #4 with Custom Super Class inherited"));
        writer.addForm(new Form("Localhost", ""));
        writer.addAction(new Note("No steps actually tested here, you can check the Java console output.<br>This is" +
                " just an example to show the ability of extend any Java class with our script..."));
        // You HAVE TO 'setCustom(...)' Acton, add members (imports, extend, implements),
        // then commit your action with 'commitCustomAction()'
        writer.setCustom(new Custom("CustomSuperClass", "System.out.println(\"I'm just an example, you can extend any other class..\");"));
        writer.extend("Object");
        writer.commitCustomAction();
        writer.write("custom_script4");
    }
}
