package com.abukhleif.akfnas.action.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "import")
@XmlAccessorType(XmlAccessType.FIELD)
public class Import {
    @XmlAttribute
    private String library;

    @Override
    public String toString() {
        if (library != null) {
            return "import " + getLibrary() + ";\n";
        }
        return "\n";
    }

    public Import() {
    }

    public Import(String library) {
        this.library = library;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }
}
