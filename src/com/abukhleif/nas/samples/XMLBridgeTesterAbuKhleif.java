package com.abukhleif.nas.samples;

import com.abukhleif.nas.action.*;
import com.abukhleif.nas.framework.Driver;
import com.abukhleif.nas.midtier.Bridge;
import com.abukhleif.nas.midtier.XMLBridge;
import com.abukhleif.nas.scope.Scenario;
import com.abukhleif.nas.scope.Site;
import com.abukhleif.nas.scope.unit.Page;


import javax.xml.bind.JAXBException;

/**
 * Test Writer Class
 *
 * @author AbuKhleif
 */
public class XMLBridgeTesterAbuKhleif {
    private static Bridge bridge;

    public static void main(String[] args) throws JAXBException {
        bridge = new XMLBridge(new Site("AbuKhleif", "http://www.abukhleif.com"), "abuKhleif", "AbuKhleif Website", Driver.CHROME);
        bridge.addScenario(new Scenario("AbuKhleif Website Discovering"));
        bridge.addPage(new Page("Main Page", ""));
        bridge.addAction(new VerifyText("Latest stories"));
        bridge.addAction(new VerifyNotText("Error 404"));
        bridge.addPage(new Page("Get Free Windows 10", "windows10-and-more-free-students"));
        bridge.addAction(new VerifyText("onthehub"));
        bridge.addAction(new VerifyText("البحث عن جامعتك"));
        bridge.write();
        bridge.execute();
        bridge.printData();
    }
}
