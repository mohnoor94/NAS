package com.abukhleif.nas.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AbuKhleif
 */

@XmlRootElement(name = "text")
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyText extends Action {
    @XmlAttribute
    private String value;
    @XmlAttribute(name = "second-value")
    private String secondValue;

    public void doAction() {
        if (secondValue == null) {
            verify(getValue(), true);
        } else {
            verify(getValue(), getSecondValue(), true);
        }
    }

    public VerifyText() {
    }

    public VerifyText(String value) {
        this.value = value;
    }

    public VerifyText(String value, String secondValue) {
        this.value = value;
        this.secondValue = secondValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }
}
