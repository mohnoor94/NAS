package samples;

import action.VerifyText;
import midtier.Writer;
import scope.Site;
import scope.unit.Page;

import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 *
 * @author AbuKhleif
 */
public class WriterTester_MultipleSitesV2 {
    private static Writer writer;

    public static void main(String[] args) throws JAXBException {
        writer = new Writer(new Site("Multiple Sites V2"));
        writer.addScenario("Twitter");
        writer.addPage(new Page("Twitter Homepage", "https://twitter.com/", "no"));
        writer.addAction(new VerifyText("Welcome to Twitter."));
        writer.addPage(new Page("About", "About", "no"));
        writer.addAction(new VerifyText("Our mission: To give everyone the power to create and share ideas and information instantly, without barriers."));
        writer.addScenario("https://web.facebook.com/");
        writer.addPage(new Page("Facebook Homepage", "https://web.facebook.com/", "no"));
        writer.addAction(new VerifyText(" Connect with friends and the"));
        writer.addAction(new VerifyText("world around you on Facebook. "));
        writer.addPage(new Page("About", "About", "no"));
        writer.addAction(new VerifyText("There is now a community of 2 billion people active on Facebook every month. To celebrate, we made a personalized video highlighting some of the good each of us puts out there each day."));
        writer.write("multiple_sites2");
    }
}
