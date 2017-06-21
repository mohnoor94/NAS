package scope;

import action.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page implements Scope {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String url;
    @XmlElement(name = "text")
    private ArrayList<Text> text;
    @XmlElement(name = "not-text")
    private ArrayList<NotText> notText;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<Text> getText() {
        if (text == null) {
            text = new ArrayList<Text>();
        }
        return text;
    }

    public ArrayList<NotText> getNotText() {
        if (notText == null) {
            notText = new ArrayList<NotText>();
        }
        return notText;
    }

    public void setText(ArrayList<Text> text) {
        this.text = text;
    }

    public void setNotText(ArrayList<NotText> notText) {
        this.notText = notText;
    }

    public void parse() {
        System.out.println("Page parsed");
    }
}


/*
@XmlElement(name = "action")
    public ArrayList<Action> getActions() {
//        if (actions == null){
//            actions = new ArrayList<Action>();
//        }
        return actions;
    }

    public void parse() {
        for (Action action: actions){
            action.doAction();
        }
    }
 */
