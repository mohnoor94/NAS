package action;

import framework.Reporter;
import runtime.MethodInvocationUtils;
import runtime.RuntimeCompiler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "custom")
@XmlAccessorType(XmlAccessType.FIELD)
public class Custom extends Action {
    @XmlAttribute
    private String code;

    public void doAction() {
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("Custom", "Start Executing Custom Code");
        try {
            String customClass = "CustomClass";
            String header = "import framework.Base;\n" +
                    "public class CustomClass extends Base{" + "\n" +
                    "    public static void customMethod() {" + "\n";
            String footer =
                    "\n    }" + "\n" +
                            "}" + "\n";
            RuntimeCompiler r = new RuntimeCompiler();
            r.addClass(customClass, header + getCode() + footer);
            r.compile();
            MethodInvocationUtils.invokeStaticMethod(
                    r.getCompiledClass(customClass),
                    "customMethod");
        } catch (Exception e) {
            System.out.println("Error Executing custom code... --> " + e);
        }
        reporter.addFooter("Custom", "Executing Custom Code Ended");
    }

    public Custom() {
    }

    public Custom(String code) {
        this.code = code;
    }

    public String getCode() {
        if (code == null) {
            code = "System.out.println(\"Empty Custom Code!\");";
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
