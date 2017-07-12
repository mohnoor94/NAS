package midtier;

import action.Action;
import action.custom.*;
import scope.Scenario;
import scope.Site;
import scope.unit.Form;
import scope.unit.Page;
import scope.unit.Unit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * This class responsibility is to create xml files (qa tests)
 *
 * @author AbuKhleif
 */
public class Writer {
    private Site site;
    private Scenario scenario;
    private Page page;
    private Form form;
    private Unit activeUnit;
    private Custom custom;
    private final String preFilePath = "." + File.separator + "xml" + File.separator;
    private final String postFilePath = ".xml";

    public void write(String fileName) throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to File
        String filePath = preFilePath + fileName + postFilePath;
        m.marshal(site, new File(filePath));
        System.out.println("XML file succesfully written to '" + filePath + "'");
    }

    public void write() throws JAXBException {
        write("site");
    }

    public Writer(Site site) {
        this.site = site;
    }

    public Site getSite() {
        return site;
    }

    public Scenario getScenario() {
        return scenario;
    }

    /**
     * Add a new scenario to the site
     *
     * @param scenario
     */
    public void addScenario(Scenario scenario) {
        this.scenario = scenario;
        if (scenario != null) {
            site.getScenarios().add(scenario);
        } else {
            throw new RuntimeException("Null Scenario");
        }
    }

    /**
     * Add a new scenario by name
     *
     * @param scenarioName
     */
    public void addScenario(String scenarioName) {
        Scenario scenario = new Scenario(scenarioName);
        addScenario(scenario);
    }

    public Page getPage() {
        return page;
    }

    public Form getForm() {
        return form;
    }

    private Unit getActiveUnit() {
        return activeUnit;
    }

    private void setActiveUnit(Unit activeUnit) {
        this.activeUnit = activeUnit;
    }

    /**
     * Add a new page to current scenario
     *
     * @param page
     */
    public void addPage(Page page) {
        if (scenario != null && page != null) {
            this.page = page;
            setActiveUnit(page);
            scenario.getUnits().add(page);
        } else {
            throw new RuntimeException("Null Scenario or Page");
        }
    }

    /**
     * Set a new form and add it to current scenario
     *
     * @param form
     */
    public void addForm(Form form) {
        if (scenario != null && form != null) {
            this.form = form;
            setActiveUnit(form);
            scenario.getUnits().add(form);
        } else {
            throw new RuntimeException("Null Scenario or Form");
        }
    }

    /**
     * Add an action to the current unit
     *
     * @param action
     */
    public void addAction(Action action) {
        getActiveUnit().getActions().add(action);
    }

    public Custom getCustom() {
        if (custom == null) {
            custom = new Custom();
        }
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public void setCustom(String title) {
        getCustom().setTitle(title);
    }

    /**
     * add import statement to the custom code...
     *
     * @param anImport
     */
    public void addImport(Import anImport) {
        getCustom().addImport(anImport);
    }

    /**
     * add import statement to the custom code...
     *
     * @param library
     */
    public void addImport(String library) {
        getCustom().addImport(new Import(library));
    }

    /**
     * Set a custom super class for your script
     * NOTE: you will loss your access to Base framework...
     * @param superClass
     */
    public void extend (String superClass){
        getCustom().setSuperClass(new Extend(superClass));
    }

    /**
     * Implement an interface...
     * @param theInterface
     */
    public void implement (String theInterface){
        getCustom().addInterface(new Implement(theInterface));
    }

    public void commitCustomAction() {
        getActiveUnit().getActions().add(custom);
    }
}