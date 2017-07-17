package com.abukhleif.akfnas.scope.unit;

import com.abukhleif.akfnas.action.Action;
import com.aventstack.extentreports.Status;
import com.abukhleif.akfnas.data.Data;
import com.abukhleif.akfnas.framework.Reporter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    @XmlAttribute
    private String relative;
    @XmlElementRef
    private ArrayList<Action> actions = new ArrayList<Action>();

    public void parse() {
        Reporter.log(Status.INFO, "Enter Form: " + getName() + " (" + getUrl() + ")");
        try {
            Data.getData().put("form", getName());

            // navigate to form
            if (getRelative().equals("no") && getUrl().equals("")) {
                // do nothing...
            } else if (getRelative().equals("no")) {
                navigate(getUrl());
            } else {
                navigate(Data.getData().get("url") + "/" + getUrl());
            }

            // do actions
            for (Action action : actions) {
                action.doAction();

            }
        } catch (Exception e) {
            Reporter.log(Status.FATAL, "While Executing Form '" +
                    getName() + " (" + getUrl() +
                    ")', All Remaining Tests at this form have been Skipped!\n" +
                    "Error Message from Executer: " + e.getMessage());
            Reporter.reportError();
        }

        Reporter.log(Status.INFO, "Leave Form: " + getName() + " (" + getUrl() + " )");
    }

    public Form() {
    }

    public Form(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Form(String name, String url, String relative) {
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

    @Override
    public String toString() {
        return "Name: " + getName() + ", url: " + getUrl() + ", isUrlRelative: " + getRelative() + "\nActions:\n" + Arrays.asList(getActions());
    }
}
