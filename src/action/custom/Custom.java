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
@XmlType(propOrder = {"aPackage", "title", "isScriptCode", "imports", "code", "variables", "methods"})
@XmlSeeAlso({Method.class, Variable.class, Import.class, Package.class})
public class Custom extends Action {
    @XmlAttribute
    private String title;
    @XmlAttribute(name = "script-code")
    private String isScriptCode;
    @XmlElement
    private String code;
    @XmlElementRef
    private ArrayList<Variable> variables;
    @XmlElementRef
    private ArrayList<Method> methods;
    @XmlElementRef
    private ArrayList<Import> imports;
    @XmlElementRef(name = "package")
    private Package aPackage;
    @XmlTransient
    private RuntimeCompiler compiler = new RuntimeCompiler();

    public void doAction() {
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("Custom", "Start Executing Custom Code (" + getTitle() + ")");
        try {
            if ("yes".equals(isScriptCode)) {
                System.out.println(buildDefaultClass());
                compiler.addClass(getTitle(), buildDefaultClass());
                compiler.compile();
                invokeDefaultMethod();
            } else {
                System.out.println(buildClass());
                compiler.addClass(getTitle(), buildClass());
                compiler.compile();
                invokeMethods();
            }
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
    public Custom(String title, String isScriptCode, String code) {
        this.title = title;
        this.isScriptCode = isScriptCode;
        this.code = code;
    }

    public Custom(String title) {
        this.title = title;
    }

    public Custom(String title, String isScriptCode, String code, Package aPackage) {
        this.title = title;
        this.isScriptCode = isScriptCode;
        this.code = code;
        this.imports = imports;
        this.aPackage = aPackage;
    }

    public Custom(String title, Package aPackage) {
        this.title = title;
        this.aPackage = aPackage;
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

    private ArrayList<Variable> getVariables() {
        if (variables == null) {
            variables = new ArrayList<>();
        }
        return variables;
    }

    private ArrayList<Method> getMethods() {
        if (methods == null) {
            methods = new ArrayList<>();
        }
        return methods;
    }

    public ArrayList<Import> getImports() {
        if (imports == null) {
            imports = new ArrayList<>();
        }
        return imports;
    }

    public String getScriptCode() {
        if (isScriptCode == null) {
            isScriptCode = "no";
        }
        return isScriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.isScriptCode = scriptCode;
    }

    public String getCode() {
        if (code == null) {
            code = "";
        }
        return code;
    }

    public String getPackageAsString() {
        if (aPackage == null) {
            return "\n";
        }
        return aPackage.toString();
    }

    public void setPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addVariable(Variable variable) {
        getVariables().add(variable);
    }

    public void addMethod(Method method) {
        getMethods().add(method);
    }

    public void addImport(Import anImport){
        getImports().add(anImport);
    }

    private String getVariablesAsString() {
        if (getVariables().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Variable variable : getVariables()) {
            sb.append(variable);
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String getMethodsAsString() {
        if (getMethods().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Method method : getMethods()) {
            sb.append("public static void ");
            sb.append(method.getName());
            sb.append("() {\n");
            sb.append(method.getCode());
            sb.append("\n\t}\n\n");
        }
        return sb.toString();
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
        sb.append("\n");
        return sb.toString();
    }

    private String buildClass() {
        return getPackageAsString() +
                getImportsAsString() +
                "import framework.Base;\n" +
                "public class " +
                getTitle() +
                " extends Base {\n" +
                getVariablesAsString() +
                getMethodsAsString() +
                "}";
    }

    private String buildDefaultClass() {
        return getPackageAsString() +
                getImportsAsString() +
                "import framework.Base;\npublic class " +
                getTitle() +
                " extends Base {\n\tpublic static void myMethod(){\n" +
                getCode() +
                "\n\t}\n}";
    }

    private void invokeMethods() {
        for (Method method : getMethods()) {
            MethodInvocationUtils.invokeStaticMethod(
                    compiler.getCompiledClass(getTitle()),
                    method.getName());
        }
    }

    private void invokeDefaultMethod() {
        MethodInvocationUtils.invokeStaticMethod(
                compiler.getCompiledClass(getTitle()),
                "myMethod");
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\nMethods:\n" + getMethodsAsString() + "Variables:\n" + getVariablesAsString() + "\n";
    }
}
