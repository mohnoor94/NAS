package com.abukhleif.akfnas.action.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "extend")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extend {
    @XmlAttribute (name = "super-class")
    private String theClass;

    @Override
    public String toString() {
        if (theClass == null) {
            return " extends Base ";
        }
        return " extends " + getTheClass() + " ";
    }

    public Extend() {
    }

    public Extend(String theClass) {
        this.theClass = theClass;
    }

    public String getTheClass() {
        return theClass;
    }

    public void setTheClass(String theClass) {
        this.theClass = theClass;
    }
}