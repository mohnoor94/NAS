package com.abukhleif.akfnas.action;

import com.abukhleif.akfnas.data.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "store-manual")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManualStore extends Action {
    @XmlAttribute
    private String key;
    @XmlAttribute
    private String value;

    public void doAction() {
        Data.getUserData().put(getKey(), getValue());
    }

    public ManualStore() {
    }

    public ManualStore(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
