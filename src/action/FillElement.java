package action;

import data.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AbuKhleif
 */
@XmlRootElement(name = "fill")
@XmlAccessorType(XmlAccessType.FIELD)
public class FillElement extends Action {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String value;
    @XmlAttribute
    private String stored;

    public void doAction() {
        if ("yes".equals(getStored())) {
            fillElement(getId(), Data.getUserData().get(value));
        } else {
            fillElement(getId(), getValue());
        }
    }

    public FillElement() {
    }

    public FillElement(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public FillElement(String id, String value, String stored) {
        this.id = id;
        this.value = value;
        this.stored = stored;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStored() {
        if (stored == null) {
            stored = "no";
        }
        return stored;
    }

    public void setStored(String stored) {
        this.stored = stored;
    }
}
