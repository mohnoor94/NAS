package action;

import data.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store extends Action {
    @XmlAttribute
    private String key;
    @XmlAttribute
    private String id;

    public void doAction() {
        Data.getUserData().put(key, getText(id));
    }

    public Store() {
    }

    public Store(String key, String id) {
        this.key = key;
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
