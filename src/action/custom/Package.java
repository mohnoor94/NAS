package action.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "package")
@XmlAccessorType(XmlAccessType.FIELD)
public class Package {
    @XmlAttribute
    private String value;

    @Override
    public String toString() {
        if (value != null) {
            return "package " + getValue() + ";\n";
        }
        return "\n";
    }

    public Package() {
    }

    public Package(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
