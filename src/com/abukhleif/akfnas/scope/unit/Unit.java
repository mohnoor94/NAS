package com.abukhleif.akfnas.scope.unit;

import com.abukhleif.akfnas.action.Action;
import com.abukhleif.akfnas.framework.Base;

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