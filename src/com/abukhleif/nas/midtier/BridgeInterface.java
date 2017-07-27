package com.abukhleif.nas.midtier;

import com.abukhleif.nas.action.Action;
import com.abukhleif.nas.action.custom.Custom;
import com.abukhleif.nas.action.custom.Import;
import com.abukhleif.nas.scope.Scenario;
import com.abukhleif.nas.scope.Site;
import com.abukhleif.nas.scope.unit.Form;
import com.abukhleif.nas.scope.unit.Page;
import com.abukhleif.nas.scope.unit.Unit;

import javax.xml.bind.JAXBException;

/**
 * An interface to deal with all functionality of the framework
 */
interface BridgeInterface {
    // Writing methods...
    void write() throws JAXBException;

    Site getSite();

    Scenario getScenario();

    /**
     * Add a new scenario to the site
     *
     * @param scenario
     */
    void addScenario(Scenario scenario);

    /**
     * Add a new scenario by name
     *
     * @param scenarioName
     */
    void addScenario(String scenarioName);

    /**
     * Add a new scenario.
     *
     * @param scenarioName
     * @param scenarioDescription
     */
    void addScenario(String scenarioName, String scenarioDescription);

    /**
     * Set thescenario description
     *
     * @param description
     */
    void setScenarioDescription(String description);

    /**
     * Add dependency to a scenario
     *
     * @param dependency
     */
    void addDependency(String dependency);

    Page getPage();

    Form getForm();

    Unit getActiveUnit();

    void setActiveUnit(Unit activeUnit);

    /**
     * Add a new page to current scenario
     *
     * @param page
     */
    void addPage(Page page);

    /**
     * Set a new form and add it to current scenario
     *
     * @param form
     */
    void addForm(Form form);

    /**
     * Add an com.abukhleif.nas.action to the current unit
     *
     * @param action
     */
    void addAction(Action action);

    Custom getCustom();

    void setCustom(Custom custom);

    void setCustom(String title);

    /**
     * add import statement to the custom code...
     *
     * @param anImport
     */
    void addImport(Import anImport);

    /**
     * add import statement to the custom code...
     *
     * @param library
     */
    void addImport(String library);

    /**
     * Set a custom super class for your script
     * NOTE: you will loss your access to Base com.abukhleif.nas.framework...
     *
     * @param superClass
     */
    void extend(String superClass);

    /**
     * Implement an interface...
     *
     * @param theInterface
     */
    void implement(String theInterface);

    void commitCustomAction();


    // Execution methods...

    void execute();

    void printData();

    String getFileName();

    void setFileName(String fileName);

    String getTitle();
}
