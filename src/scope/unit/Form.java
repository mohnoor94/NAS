package scope.unit;

import action.Action;
import action.FillElement;
import data.Data;
import framework.Base;
import scope.Scope;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.FIELD)
public class Form extends Unit {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String url;
    @XmlAttribute(name = "submit-button")
    private String submitButton;
    @XmlElementRef
    private ArrayList<Action> actions = new ArrayList<Action>();

    public void parse() {
        // TODO report form header
        navigate(Data.getData().get("url") + getUrl());
        for (Action action : actions) {
            action.doAction();
        }
        // submit form
        if (submitButton != null) {
            navigate(submitButton);
        } else {
            for (Action action : actions) {
                if (action instanceof FillElement) {
                    submit(((FillElement) action).getId());
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        if (url == null) {
            url = "";
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Action> getActions() {
        if (actions == null) {
            actions = new ArrayList<Action>();
        }
        return actions;
    }

    public String getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(String submitButton) {
        this.submitButton = submitButton;
    }
}
