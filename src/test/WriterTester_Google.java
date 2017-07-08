package test;

import action.FillElement;
import action.Submit;
import action.VerifyNotText;
import action.VerifyText;
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
public class WriterTester_Google {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Google", "https://www.google.jo/"));
        writer.addScenario(new Scenario("Search"));
        writer.addForm(new Form("Search Form", ""));
        writer.addAction(new VerifyText("الأردن"));
        writer.addAction(new VerifyText("Google.jo"));
        writer.addAction(new FillElement("lst-ib", "How to search google? =P"));
        writer.addAction(new Submit("lst-ib"));
        writer.addAction(new VerifyText("How to search on Google"));
        writer.addPage(new Page("First Result", "//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a[2]/span", "no"));
        writer.addAction(new VerifyNotText("Error 404"));
        writer.addAction(new VerifyText("How to search on Google"));
        writer.addAction(new VerifyText("Google Search"));
        writer.addAction(new VerifyText("Tip 1: Start with the basics"));
        writer.addAction(new VerifyText("Expert Search tips"));
        writer.write("google");
    }
}
