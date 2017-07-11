package action;

import action.custom.Custom;
import framework.Base;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author AbuKhleif
 */
@XmlSeeAlso({Click.class, ClickCheckbox.class, FillElement.class,
        ManualStore.class, VerifyNotText.class, VerifyAlert.class,
        RespondAlert.class, Select.class, Store.class,
        Submit.class, VerifyText.class, Custom.class, Note.class})
public abstract class Action extends Base {
    public abstract void doAction();
}