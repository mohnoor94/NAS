package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mkhlif on 6/20/17.
 */

@XmlRootElement(name = "navigate-checkbox")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClickCheckbox extends Action {
    private String id;
    private Integer index;

    public void doAction() {
        System.out.println();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}