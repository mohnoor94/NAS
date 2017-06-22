package scope.unit;

import framework.Base;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author AbuKhleif
 */
@XmlSeeAlso({Form.class, Page.class})
public abstract class Unit extends Base {
    public void parse() {
    }
}
