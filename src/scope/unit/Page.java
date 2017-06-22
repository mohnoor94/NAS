package scope.unit;

import action.*;
import data.Data;
import framework.Base;
import scope.Scope;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page extends Unit {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String url;
    @XmlElementRef
    private ArrayList<Action> actions = new ArrayList<Action>();

    public void parse() {
        // TODO report page header
        if (getUrl() != null)
            navigate(Data.getData().get("url") + getUrl());
        for (Action action : actions) {
            action.doAction();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
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


}
