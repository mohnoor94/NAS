package midtier;

import action.Action;
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
    private final String preFilePath = "./xml" + File.separator;
    private final String postFilePath = ".xml";

    public void write(String fileName) throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Site.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to File
        m.marshal(site, new File(preFilePath + fileName + postFilePath));
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

    public Page getPage() {
        return page;
    }

    public Form getForm() {
        return form;
    }

    public Unit getActiveUnit() {
        return activeUnit;
    }

    public void setActiveUnit(Unit activeUnit) {
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
     * @param action
     */
    public void addAction(Action action) {
        getActiveUnit().getActions().add(action);
    }
}
