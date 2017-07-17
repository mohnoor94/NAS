package com.abukhleif.akfnas.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AbuKhleif
 */

@XmlRootElement(name = "verify-alert")
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyAlert extends Action {
    @XmlAttribute (name = "expected")
    private String expectedValue;

    public void doAction() {
        if (getExpectedValue() != null){
            verify(getExpectedValue(), getAlertText(), true);
        }
    }

    public VerifyAlert() {
    }

    public VerifyAlert(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }
}
