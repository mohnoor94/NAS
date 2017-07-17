package com.abukhleif.akfnas.scope.unit;

import com.abukhleif.akfnas.action.Action;
import com.aventstack.extentreports.Status;
import com.abukhleif.akfnas.data.Data;
import com.abukhleif.akfnas.framework.Reporter;

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
    @XmlAttribute
    private String relative;
    @XmlElementRef
    private ArrayList<Action> actions = new ArrayList<Action>();

    public void parse() {
        Reporter.log(Status.INFO, "Enter Page: " + getName() + " (" + getUrl() + ")");
        try {
            // navigate to page
            if (getRelative().equals("no") && getUrl().equals("")) {
                // do nothing...
            } else if ("no".equals(getRelative())) {
                navigate(getUrl());
            } else {
                navigate(Data.getData().get("url") + "/" + getUrl());
            }

            // do actions
            for (Action action : actions) {
                action.doAction();
            }
        } catch (Exception e) {
            Reporter.log(Status.FATAL, "While Executing Page '" +
                    getName() + " (" + getUrl() +
                    ")', All Remaining Tests at this page have been Skipped!\n" +
                    "Error Message from Executer: " + e.getMessage());
            Reporter.reportError();
        }

        Reporter.log(Status.INFO, "Leave Page: " + getName() + " (" + getUrl() + " )");
    }

    public Page() {
    }

    public Page(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Page(String name, String url, String relative) {
        this.name = name;
        this.url = url;
        this.relative = relative;
    }

    public String getName() {
        if (name == null) {
            name = "UNKNOWN";
        }
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

    public String getRelative() {
        if (relative == null) {
            relative = "yes";
        }
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    @Override
    public ArrayList<Action> getActions() {
        if (actions == null) {
            actions = new ArrayList<Action>();
        }
        return actions;
    }


}
