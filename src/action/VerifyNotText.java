package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "not-text")
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyNotText extends Action {
    @XmlAttribute
    private String value;

    public void doAction() {
        verify(getValue(), false);
    }

    public VerifyNotText() {
    }

    public VerifyNotText(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
