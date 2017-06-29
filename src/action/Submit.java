package action;

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

    public void doAction() {
        if (getElement() != null) {
            submit(getElement());
        }
    }

    public Submit() {
    }

    public Submit(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
