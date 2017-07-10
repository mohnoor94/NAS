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
    public abstract void parse();
    public abstract ArrayList<Action> getActions();
}