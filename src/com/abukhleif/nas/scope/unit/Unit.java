package com.abukhleif.nas.scope.unit;

import com.abukhleif.nas.action.Action;
import com.abukhleif.nas.framework.Base;

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