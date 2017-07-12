package samples;

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
public class WriterTester_Custom2 extends Base {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Custom Code Injection! - Test  #2"));
        writer.addForm(new Form("Search Page", ""));
        writer.addAction(new VerifyText("الأردن"));
        StringBuilder sb = new StringBuilder();
        sb.append("String directSearch = \"https://www.google.jo/search?q=abukhleif\";\n");
        sb.append("navigate(directSearch);\n");
        sb.append("navigate(\"Abu Khleif | Programimng and Coding C++, Java and Android\");\n");
        sb.append("verify(\"Latest stories\",true);\n");
        sb.append("verify(\"Page not found\",false);\n");
        // no need to commit Custom Action if it does not contains members (methods, imports, or variables)...
        writer.addAction(new Custom("Navigation1", sb.toString()));
        writer.write("custom_script2");
    }
}
