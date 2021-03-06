package com.abukhleif.nas.action;

import com.aventstack.extentreports.Status;
import com.abukhleif.nas.framework.Reporter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note extends Action {
    @XmlAttribute
    private String text;

    public void doAction() {
        Reporter.log(Status.INFO, "User Note: " + getText());
    }

    public Note() {
    }

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        if (text == null) {
            text = "No text!";
        }
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
