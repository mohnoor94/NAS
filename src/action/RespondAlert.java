package action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "response-alert")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespondAlert extends Action {
    @XmlAttribute
    private boolean response;

    public void doAction() {
        respondAlert(isResponse());
    }

    public RespondAlert() {
    }

    public RespondAlert(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
