package scope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by mkhlif on 6/20/17.
 */
@XmlRootElement(name = "scenario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scenario implements Scope {
    public String name;
    @XmlElement(name = "page")
    public ArrayList<Page> pages;


    public void parse() {
        for (Page page : pages) {
            page.parse();
        }
    }
}
