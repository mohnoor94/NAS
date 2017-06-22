package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "navigate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Click extends Action {
    @XmlAttribute
    private String id;

    public void doAction() {
        navigate(id);
    }

    public Click() {
    }

    public Click(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
