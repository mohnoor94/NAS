package com.abukhleif.akfnas.action;

import com.aventstack.extentreports.Status;
import com.abukhleif.akfnas.data.Data;
import com.abukhleif.akfnas.framework.Reporter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "submit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Submit extends Action {
    @XmlAttribute
    private String element;
    @XmlAttribute
    private String type;
    // type = button or field

    public void doAction() {
        if (getElement() != null) {
            if ("field".equals(getType())) {
                submit(getElement());
            } else {
                navigate(getElement());
            }
            Reporter.log(Status.INFO, "Submit Form '" + Data.getData().get("form") + "' via '" + getElement() + "'");
        }
    }

    public Submit() {
    }

    public Submit(String element) {
        this.element = element;
    }

    public Submit(String element, String type) {
        this.element = element;
        this.type = type;
    }

    public String getElement() {
        return element;
    }

    public String getType() {
        if (type == null) {
            type = "field";
        }
        return type;
    }
}
