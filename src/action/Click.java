package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mkhlif on 6/20/17.
 */

@XmlRootElement(name = "click")
@XmlAccessorType(XmlAccessType.FIELD)
public class Click implements Action {
    private String id;

    public void doAction() {
        System.out.println("click " + id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
