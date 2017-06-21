package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */
@XmlRootElement(name = "fill")
@XmlAccessorType(XmlAccessType.FIELD)
public class FillElement extends Action {
    private String id;
    private String value;

    public void doAction() {

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
}
