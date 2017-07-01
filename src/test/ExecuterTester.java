package test;

import midtier.Executer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Test Executer Class
 * @author AbuKhleif
 */
public class ExecuterTester {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Executer executer = new Executer();
        executer.execute("noor");
        executer.printData();
    }
}
