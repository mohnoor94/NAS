package samples;

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
public class WriterTester_Custom3_Imports extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("CodeForces", "http://codeforces.com/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #3 with Import Statement"));
        writer.addForm(new Form("F. Dirty Arkady's Kitchen", "problemset/problem/827/F"));
        // You HAVE TO 'setCustom(...)' Acton, add members (imports, extend, implements),
        // then commit your action with 'commitCustomAction()'
        writer.setCustom(new Custom("SharedWordsVerifying", "ArrayList<String> texts = new ArrayList<>();\n" +
                "        texts.add(\"Input\");\n" +
                "        texts.add(\"Output\");\n" +
                "        texts.add(\"Examples\");\n" +
                "        texts.add(\"Codeforces\");\n" +
                "        texts.add(\"Virtual participation\");\n" +
                "        texts.add(\"Problem tags\");\n" +
                "        texts.add(\"Contest materials\");\n" +
                "        for (String text : texts){\n" +
                "            verify(text, true);\n" +
                "        }"));
        writer.addImport("java.util.ArrayList");
        writer.commitCustomAction();
        writer.write("custom_script3");
    }
}
