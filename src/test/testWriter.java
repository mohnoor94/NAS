package test;

import action.*;
import data.Data;
import framework.Base;
import midtier.Writer;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;

import javax.xml.bind.JAXBException;

/**
 * Created by mkhlif on 6/29/17.
 */
public class testWriter {
    static Writer writer;

    public static void main(String[] args) throws JAXBException {
        register();
        login();
        writer.write("noor");
    }

    private static void login() {
        writer.setScenario(new Scenario("Login"));
        writer.setForm(new Form("Login Form", "/V4/index.php"));
        writer.addAction(new Text("Steps To Generate Access"));
        writer.addAction(new FillElement("uid", Data.getUserData().get("username")));
        writer.addAction(new FillElement("password", Data.getUserData().get("password")));
        writer.addAction(new Submit("uid"));
        writer.addAction(new Text("Welcome To Manager's Page of Guru99 Bank"));
        writer.commitActions();
    }

    static void register() {
        Site site = new Site();
        site.setUrl("http://demo.guru99.com");
        site.setName("Guru 99 Bank");

        writer = new Writer(site);

        writer.setScenario(new Scenario());
        writer.getScenario().setName("Register");

        writer.setForm(new Form());
        writer.getForm().setName("Guru 99 bank Register");

        Text t1 = new Text("Enter your email address to get");
        Text t2 = new Text("Access details to demo site.");
        NotText notFound = new NotText("Error 404");
        Text t3 = new Text("This access is valid only for 20 days.");
        Text akt1 = new Text("Latest stories");
        Text akt2 = new Text("Abu Khleif");

        FillElement fill = new FillElement("emailid", "email@example.com");

        Store username = new Store("username", "/html/body/table/tbody/tr[4]/td[2]");
        Store password = new Store("password", "/html/body/table/tbody/tr[5]/td[2]");

        Submit submit = new Submit("emailid");


        writer.addAction(t1);
        writer.addAction(notFound);
        writer.addAction(fill);
        writer.addAction(submit);
        writer.addAction(t2);
        writer.addAction(t3);
        writer.addAction(username);
        writer.addAction(password);
        writer.addAction(notFound);

        writer.commitActions();

        System.out.println(Data.getUserData().get("username"));
        System.out.println(Data.getUserData().get("password"));

    }
}
