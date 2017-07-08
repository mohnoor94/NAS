package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "click-checkbox")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClickCheckbox extends Action {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private Integer index;

    public void doAction() {
        clickCheckbox(getId(), getIndex());
    }

    public ClickCheckbox() {
    }

    public ClickCheckbox(String id, Integer index) {
        this.id = id;
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}