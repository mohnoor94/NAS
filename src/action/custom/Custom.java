package action.custom;

import action.Action;
import framework.Reporter;
import runtime.MethodInvocationUtils;
import runtime.RuntimeCompiler;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */

@XmlRootElement(name = "custom")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"title", "imports", "code"})
@XmlSeeAlso({Import.class})
public class Custom extends Action {
    @XmlAttribute
    private String title;
    @XmlElement
    private String code;
    @XmlElementRef
    private ArrayList<Import> imports;
    @XmlTransient
    private RuntimeCompiler compiler = new RuntimeCompiler();

    public void doAction() {
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("Custom", "Start Executing Custom Code (" + getTitle() + ")");
        try {
            System.out.println(buildClass());
            compiler.addClass(getTitle(), buildClass());
            compiler.compile();
            invokeDefaultMethod();
        } catch (Exception e) {
            System.out.println("Error Executing custom code... --> " + e);
            reporter.addHeader("ERROR", "'" + getTitle() + "' contains errors! Check the console for more details.</br>" +
                    "Error Message from Executer: " + e);
        }
        reporter.addFooter("Custom", "Executing Custom Code Ended (" + getTitle() + ")");
    }

    public Custom() {
    }

    // script only code...
    public Custom(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public Custom(String title) {
        this.title = title;
    }

    public String getTitle() {
        if (title == null) {
            title = "Untitled";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private ArrayList<Import> getImports() {
        if (imports == null) {
            imports = new ArrayList<>();
        }
        return imports;
    }

    public String getCode() {
        if (code == null) {
            code = "";
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addImport(Import anImport) {
        getImports().add(anImport);
    }

    private String getImportsAsString() {
        if (getImports().isEmpty()) {
            return "\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Import im : getImports()) {
            sb.append(im);
            sb.append("\n");
        }
        sb.append("import framework.Base;\n");
        return sb.toString();
    }


    private String buildClass() {
        return getImportsAsString() +
                "public class " +
                getTitle() +
                " extends Base {\n\tpublic static void myMethod(){\n" +
                getCode() +
                "\n\t}\n}";
    }

    private void invokeDefaultMethod() {
        MethodInvocationUtils.invokeStaticMethod(
                compiler.getCompiledClass(getTitle()),
                "myMethod");
    }
}
