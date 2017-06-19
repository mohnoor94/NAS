package test;


/**
 * Test some operations on demo.guru99.com website
 *
 * @author AbuKhleif
 */
public class Guru99Tests extends Framework {
    private String randomEmail, username, password, id;

    public static void main(String[] args) {
        Guru99Tests obj = new Guru99Tests();
        obj.setUp();
        obj.register();
        obj.login();
        obj.createNewCustomer();
        obj.createNewAccount();
        obj.logout();
        obj.tearDown();
    }

    /**
     * Test registration operation
     */
    public void register() {
        //open website
        openURL("http://demo.guru99.com/");

        // verify message
        verify("Enter your email address to get");
        verify("access details to demo site");

        // fill email with random email
        randomEmail = generateRandomEmail();
        fillElement("emailid", randomEmail);

        // register
        submit("emailid");

        // verify messages
        verify("Access details to demo site.");
        verify("This access is valid only for 20 days.");

        // get username and save it
        username = getText("/html/body/table/tbody/tr[4]/td[2]");

        // get password and save it
        password = getText("/html/body/table/tbody/tr[5]/td[2]");
    }

    /**
     * Test login operation
     */
    public void login() {
        // open login page
        openURL("http://demo.guru99.com/V4/index.php");

        // Verify that the appearance of the message
        verify("Steps To Generate Access");

        // fill username with stored value
        fillElement("uid", username);

        // fill password with stored value
        fillElement("password", password);

        // submit form and login (via username box)
        submit("uid");

        // Verify that the appearance of the message
        verify("Welcome To Manager's Page of Guru99 Bank");
    }

    /**
     * Test create new customer operation
     */
    public void createNewCustomer() {
        // Click New Customer Link
        click("/html/body/div[2]/div/ul/li[2]/a");

        // Verify message
        verify("Add New Customer");

        // Fill Form
        // name
        fillElement("name", "Mohammad Noor");

        // gender
        click("rad1", 0);

        // date of birth
        fillElement("dob", "05/22/1994");

        // Address
        fillElement("addr", "Amman Jordan");

        // City
        fillElement("city", "Amman");

        // State
        fillElement("state", "Unknown");

        // Pin
        fillElement("pinno", "123456");

        // Mobile
        fillElement("telephoneno", "0786201850");

        // Email
        fillElement("emailid", randomEmail);

        // Password
        fillElement("password", password);

        // submit
        click("sub");

        // verify message
        verify("Customer Registered Successfully!!!");

        // get id
        id = getText("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
    }

    /**
     * Test create new account operation
     */
    public void createNewAccount() {
        // Click New Account Link
        click("/html/body/div[2]/div/ul/li[5]/a");

        // Verify message
        verify("Add new account form");

        // Fill Form
        // customer id
        fillElement("cusid", id);

        // account type
        select("selaccount", "Current");

        // initial deposit
        fillElement("inideposit", "1000");

        // Submit
        click("button2");

        // Verify message
        verify("Account Generated Successfully!!!");
    }

    /**
     * Test logout operation..
     */
    public void logout() {
        // Click Logout link
        click("/html/body/div[2]/div/ul/li[15]/a");

        // Get the text of the alert or prompt
        verify(getAlertText(), "You Have Succesfully Logged Out!!");

        // Acknowledge the alert
        respondAlert(true);

        // Verify message
        verify("Steps To Generate Access");
    }
}