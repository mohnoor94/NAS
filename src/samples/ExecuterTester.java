package samples;

import framework.Base;
import framework.Driver;
import midtier.Executer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Test Executer Class
 * Using this class you can convert any Java-written samples case to its equivalent XML samples file.
 *
 * @author AbuKhleif
 */
public class ExecuterTester extends Base {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Executer executer;
//        executer = new Executer("guru99", Driver.CHROME);
//        executer = new Executer("abukhleif", Driver.CHROME);
//        executer = new Executer("google", Driver.CHROME);
//        executer = new Executer("multiple_sites", Driver.CHROME);
//        executer = new Executer("multiple_sites2", Driver.CHROME);
//        executer = new Executer("abukhleif_login", Driver.CHROME);
//        executer = new Executer("abukhleif_login2", Driver.CHROME);
//        executer = new Executer("guru99_errors", Driver.CHROME);
//        executer = new Executer("custom_script", Driver.CHROME);
//        executer = new Executer("custom_script2", Driver.CHROME);
//        executer = new Executer("custom_script3", Driver.CHROME);
//        executer = new Executer("custom_script4", Driver.CHROME);
//        executer = new Executer("custom_script5", Driver.CHROME);
//        executer = new Executer("report_notes", Driver.CHROME);
        executer = new Executer("guru99_dependencies", Driver.CHROME);
        executer.execute();
        executer.printData();
    }
}
