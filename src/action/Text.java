package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mkhlif on 6/20/17.
 */

@XmlRootElement(name = "text")
@XmlAccessorType(XmlAccessType.FIELD)
public class Text implements Action {
    private String value;

    public void doAction() {
        System.out.println("text: " + value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
