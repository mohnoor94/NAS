package samples;

import action.*;
import midtier.Writer;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;
import scope.unit.Page;

import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 * Test Login via manually saved data
 * @author AbuKhleif
 */
public class WriterTester_AbuKhleifLoginV2 {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("AbuKhleif", "http://www.abukhleif.com"));
        writer.addScenario(new Scenario("Login via manually saved data"));
        writer.addPage(new Page("Main Page", ""));
        writer.addAction(new VerifyText("Latest stories"));
        writer.addForm(new Form("Login Page", "wp-login.php"));
        writer.addAction(new ManualStore("username", "samples"));
        writer.addAction(new ManualStore("password","thisIsATest"));
        writer.addAction(new VerifyText("Username or Email Address"));
        writer.addAction(new VerifyText("Password"));
        writer.addAction(new VerifyNotText("Error 404"));
        writer.addAction(new FillElement("user_login", "username", "yes"));
        writer.addAction(new FillElement("user_pass", "password", "yes"));
        writer.addAction(new Submit("wp-submit"));
        writer.addForm(new Form("Profile Page - English", "","no"));
        writer.addAction(new VerifyNotText(": Incorrect username or password."));
        writer.addAction(new VerifyText("Profile"));
        writer.addAction(new Select("locale", "العربية"));
        writer.addAction(new Submit("submit"));
        writer.addForm(new Form("Profile Page - Arabic", "","no"));
        writer.addAction(new VerifyText("حسابك"));
        writer.addAction(new Select("locale", "English (UK)"));
        writer.addAction(new Submit("submit"));
        writer.addForm(new Form("Profile Page - English", "","no"));
        writer.addAction(new VerifyText("Profile"));
        writer.write("abukhleif_login2");
    }
}
