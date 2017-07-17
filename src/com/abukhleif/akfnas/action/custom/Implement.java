package com.abukhleif.akfnas.action.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "implement")
@XmlAccessorType(XmlAccessType.FIELD)
public class Implement {
    @XmlAttribute (name = "interface")
    private String theInterface;

    public Implement() {
    }

    public Implement(String theInterface) {
        this.theInterface = theInterface;
    }

    public String getInterface() {
        return theInterface;
    }

    public void setInterface(String theInterface) {
        this.theInterface = theInterface;
    }
}