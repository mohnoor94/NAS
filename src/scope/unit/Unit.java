package scope.unit;

import action.Action;
import framework.Base;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */
@XmlSeeAlso({Form.class, Page.class})
public abstract class Unit extends Base {
    public void parse() {
    }

    /**
     * must be implemented/overrided in all children
     *
     * @return
     */
    public ArrayList<Action> getActions() {
        return null;
    }
}
