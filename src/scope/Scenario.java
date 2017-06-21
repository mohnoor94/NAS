package scope;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by mkhlif on 6/20/17.
 */
@XmlRootElement(name = "scenario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scenario extends Scope {
    @XmlAttribute
    public String name;
    @XmlElement(name = "page")
    public ArrayList<Page> pages;

    public void parse() {
        System.out.println("Scenario Parsed");
        for (Page page : pages) {
            page.parse();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
}
