package action.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "var")
@XmlAccessorType(XmlAccessType.FIELD)
public class Variable {
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String value;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getName() != null && getValue() != null) {
            switch (getType().toLowerCase()) {
                case "int":
                case "double":
                case "char":
                case "boolean":
                case "long":
                case "short":
                case "byte":
                case "float":
                    sb.append("static ");
                    sb.append(getType().toLowerCase());
                    break;
                case "string":
                    sb.append("private static String ");
                    sb.append(getName());
                    sb.append(" = \"");
                    sb.append(getValue());
                    sb.append("\";");
                    return sb.toString();
                default:
                    return "//Unsupported variable type!";
            }
            sb.append(" ");
            sb.append(getName());
            sb.append(" = ");
            sb.append(getValue());
            sb.append(";");
            return sb.toString();
        }
        return "//Variable syntax error..";
    }

    private Variable() {
    }

    public Variable(String type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    private String getType() {
        if (type == null) {
            type = "int";
        }
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }
}
