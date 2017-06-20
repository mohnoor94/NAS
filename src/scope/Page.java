package scope;

import action.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by mkhlif on 6/20/17.
 */

@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page implements Scope {
    @XmlAttribute
    private String name;
    @XmlElement(name = "text")
    private ArrayList<Text> text;
    @XmlElement(name = "not-text")
    private ArrayList<NotText> notText;
    @XmlElement(name = "fill")
    private ArrayList<FillElement> fill;
    @XmlElement(name = "click")
    private ArrayList<Click> click;
    @XmlElement(name = "fill")
    private ArrayList<ClickCheckbox> clickCheckbox;
    @XmlElement(name = "select")
    private ArrayList<Select> select;


    public String getName() {
        return name;
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


    public ArrayList<FillElement> getFill() {
        if (fill == null) {
            fill = new ArrayList<FillElement>();
        }
        return fill;
    }

    public ArrayList<Click> getClick() {
        if (click == null) {
            click = new ArrayList<Click>();
        }
        return click;
    }

    public ArrayList<ClickCheckbox> getClickCheckbox() {
        if (clickCheckbox == null) {
            clickCheckbox = new ArrayList<ClickCheckbox>();
        }
        return clickCheckbox;
    }

    public ArrayList<Select> getSelect() {
        if (select == null) {
            select = new ArrayList<Select>();
        }
        return select;
    }

    public void setText(ArrayList<Text> text) {
        this.text = text;
    }

    public void setNotText(ArrayList<NotText> notText) {
        this.notText = notText;
    }

    public void setFill(ArrayList<FillElement> fill) {
        this.fill = fill;
    }

    public void setClick(ArrayList<Click> click) {
        this.click = click;
    }

    public void setClickCheckbox(ArrayList<ClickCheckbox> clickCheckbox) {
        this.clickCheckbox = clickCheckbox;
    }

    public void setSelect(ArrayList<Select> select) {
        this.select = select;
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
