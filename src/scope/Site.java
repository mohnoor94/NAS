package scope;

import data.Data;

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
        // TODO report site header
        Data.getData().put("url", getUrl());
        navigate(getUrl());
        for (Scenario scenario : scenarios) {
            scenario.parse();
        }
    }

    public String getUrl() {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
