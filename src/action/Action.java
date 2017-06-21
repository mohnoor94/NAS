package action;

import framework.Base;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by mkhlif on 6/20/17.
 */
@XmlSeeAlso({Text.class, NotText.class})
public abstract class Action extends Base {
    public abstract void doAction();
}
