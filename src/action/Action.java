package action;

import framework.Base;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author AbuKhleif
 */
@XmlSeeAlso({Click.class, ClickCheckbox.class, FillElement.class,
        ManualStore.class, NotText.class, Select.class, Store.class,
        Text.class})
public abstract class Action extends Base {
    public abstract void doAction();
}