package scope;

import data.Data;
import framework.Reporter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@XmlRootElement(name = "site")
@XmlAccessorType(XmlAccessType.FIELD)
public class Site extends Scope {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String url;
    @XmlElement(name = "scenario")
    private ArrayList<Scenario> scenarios;

    public void parse() {
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("site", getName() + " (" + getUrl()+")");
        Data.getData().put("url", getUrl());
        navigate(getUrl());
        for (Scenario scenario : scenarios) {
            scenario.parse();
        }
        reporter.addFooter("site", getName() + " (" + getUrl()+")");
    }

    public Site() {
    }

    public Site(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        if (url == null) {
            url = "#";
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Scenario> getScenarios() {
        if (scenarios == null) {
            scenarios = new ArrayList<Scenario>();
        }
        return scenarios;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
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
}
