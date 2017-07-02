package test;

import action.*;
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
public class WriterTester {
    private static Writer writer;
    private static String randomEmail;

    public static void main(String[] args) throws JAXBException {
        Base base = new Base();
        randomEmail = base.generateRandomEmail();
        register();
        login();
        createNewCustomer();
        createNewAccount();
        logout();
        writer.write("noor");
    }

    private static void logout() {
        writer.addScenario(new Scenario("Logout"));
        writer.addForm(new Form("Logout Form", "/html/body/div[2]/div/ul/li[15]/a", "no"));
        writer.addAction(new VerifyAlert("You Have Succesfully Logged Out!!"));
        writer.addAction(new RespondAlert(true));
        writer.addAction(new VerifyText("Steps To Generate Access"));
    }

    private static void createNewAccount() {
        writer.addScenario(new Scenario("Create New Account"));
        writer.addForm(new Form("Create Account Form", "/html/body/div[2]/div/ul/li[5]/a", "no"));
        writer.addAction(new VerifyText("Add new account form"));
        writer.addAction(new FillElement("cusid", "id", "yes"));
        writer.addAction(new Select("selaccount", "Current"));
        writer.addAction(new FillElement("inideposit", "1000"));
        writer.addAction(new Submit("button2", "button"));
        writer.addAction(new VerifyText("Account Generated Successfully!!!"));
    }

    private static void createNewCustomer() {
        writer.addScenario(new Scenario("Create New Customer"));
        writer.addForm(new Form("Create Customer Form", "/html/body/div[2]/div/ul/li[2]/a", "no"));
        writer.addAction(new VerifyText("Add New Customer"));
        writer.addAction(new FillElement("name", "Mohammad Noor"));
        writer.addAction(new ClickCheckbox("rad1", 0));
        writer.addAction(new FillElement("dob", "05221994"));
//        writer.addAction(new FillElement("dob", "0019940522"));
        writer.addAction(new FillElement("addr", "Amman Jordan"));
        writer.addAction(new FillElement("city", "Amman"));
        writer.addAction(new FillElement("state", "Unknown"));
        writer.addAction(new FillElement("pinno", "123456"));
        writer.addAction(new FillElement("telephoneno", "0786201850"));
        writer.addAction(new FillElement("emailid", randomEmail));
        writer.addAction(new FillElement("password", "password" , "yes"));
        writer.addAction(new Submit("sub", "button"));
        writer.addAction(new VerifyText("Customer Registered Successfully!!!"));
        writer.addAction(new Store("id", "//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));
    }

    private static void login() {
        writer.addScenario(new Scenario("Login"));
        writer.addForm(new Form("Login Form", "/V4/index.php"));
        writer.addAction(new VerifyText("Steps To Generate Access"));
        writer.addAction(new FillElement("uid", "username", "yes"));
        writer.addAction(new FillElement("password", "password", "yes"));
        writer.addAction(new Submit("uid"));
        writer.addAction(new VerifyText("Welcome To Manager's Page of Guru99 Bank"));
    }

    static void register() {
        writer = new Writer(new Site("Guru 99 Bank", "http://demo.guru99.com"));
        writer.addScenario(new Scenario("Register"));
        writer.addForm(new Form("Guru 99 bank Register", ""));
        writer.addAction(new VerifyText("Enter your email address to get"));
        writer.addAction(new VerifyNotText("Error 404"));
        writer.addAction(new FillElement("emailid", "email@example.com"));
        writer.addAction(new Submit("emailid"));
        writer.addAction(new VerifyText("Access details to demo site."));
        writer.addAction(new VerifyText("This access is valid only for 20 days."));
        writer.addAction(new Store("username", "/html/body/table/tbody/tr[4]/td[2]"));
        writer.addAction(new Store("password", "/html/body/table/tbody/tr[5]/td[2]"));
        writer.addAction(new VerifyNotText("Error 404"));}
}
