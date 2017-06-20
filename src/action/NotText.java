package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mkhlif on 6/20/17.
 */

@XmlRootElement(name = "not-text")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotText implements Action {
    private String value;

    public void doAction() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
