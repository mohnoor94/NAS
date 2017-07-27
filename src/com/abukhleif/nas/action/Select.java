package com.abukhleif.nas.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "select")
@XmlAccessorType(XmlAccessType.FIELD)
public class Select extends Action {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String text;

    public void doAction() {
        select(getId(), getText());
    }

    public Select() {
    }

    public Select(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}