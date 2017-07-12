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
@XmlType(propOrder = {"title", "imports", "superClass", "interfaces", "code"})
@XmlSeeAlso({Import.class, Extend.class, Implement.class})
public class Custom extends Action {
    @XmlAttribute
    private String title;
    @XmlElement
    private String code;
    @XmlElementRef
    private ArrayList<Import> imports;
    @XmlElementRef
    private Extend superClass;
    @XmlElementRef
    private ArrayList<Implement> interfaces;
    @XmlTransient
    private RuntimeCompiler compiler = new RuntimeCompiler();

    public void doAction() {
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("Custom", "Start Executing Custom Code (" + getTitle() + ")");
        try {
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

    public Custom(String title) {
        this.title = title;
    }

    public Custom(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public Custom(String title, String code, Extend superClass) {
        this.title = title;
        this.code = code;
        this.superClass = superClass;
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

    public Extend getSuperClass() {
        return superClass;
    }

    public void setSuperClass(Extend superClass) {
        this.superClass = superClass;
    }

    public ArrayList<Implement> getInterfaces() {
        if (interfaces == null){
            interfaces = new ArrayList<>();
        }
        return interfaces;
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

    public void addInterface(Implement theInterface){
        getInterfaces().add(theInterface);
    }

    private String getSuperClassAsString() {
        if (superClass == null) {
            return " extends Base ";
        }
        return superClass.toString();
    }

    private String getInterfacesAsString(){
        if (getInterfaces().isEmpty()){
            return "";
        } else if (getInterfaces().size()==1){
            return "implements " +getInterfaces().get(0).getInterface();
        } else {
            StringBuilder sb = new StringBuilder("implements ");
            for (Implement implement : getInterfaces()){
                sb.append(implement.getInterface());
                sb.append(", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(", "));
            return sb.toString();
        }
    }

    private String getImportsAsString() {
        if (getImports().isEmpty()) {
            return "import framework.Base;\n";
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
                getSuperClassAsString() +
                getInterfacesAsString() +
                " {\n\tpublic static void myMethod(){\n" +
                getCode() +
                "\n\t}\n}";
    }

    private void invokeDefaultMethod() {
        MethodInvocationUtils.invokeStaticMethod(
                compiler.getCompiledClass(getTitle()),
                "myMethod");
    }
}
