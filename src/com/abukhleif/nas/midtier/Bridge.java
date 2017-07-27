package com.abukhleif.nas.midtier;

import com.abukhleif.nas.action.Action;
import com.abukhleif.nas.action.custom.Custom;
import com.abukhleif.nas.action.custom.Extend;
import com.abukhleif.nas.action.custom.Implement;
import com.abukhleif.nas.action.custom.Import;
import com.abukhleif.nas.data.Data;
import com.abukhleif.nas.framework.Driver;
import com.abukhleif.nas.scope.Scenario;
import com.abukhleif.nas.scope.Site;
import com.abukhleif.nas.scope.dependency.Dependency;
import com.abukhleif.nas.scope.unit.Form;
import com.abukhleif.nas.scope.unit.Page;
import com.abukhleif.nas.scope.unit.Unit;

import java.util.Collections;


/**
 * A class to deal with all functionality of the framework, this class can be extended to deal with any
 * input interface from the user
 */
public abstract class Bridge implements BridgeInterface {
    Site site = null;
    private Scenario scenario = null;
    private Page page = null;
    private Form form = null;
    private Unit activeUnit = null;
    private Custom custom = null;
    String fileName = null;
    private String title = null;
    Driver driver = null;
    String preFilePath;
    String postFilePath;

    public Bridge(Site site, String fileName) {
        this.site = site;
        this.fileName = fileName;
    }

    public Bridge(Site site, String fileName, Driver driver) {
        this.site = site;
        this.fileName = fileName;
        this.driver = driver;
    }

    public Bridge(Site site, String fileName, String title, Driver driver) {
        this.site = site;
        this.fileName = fileName;
        this.title = title;
        this.driver = driver;
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public Scenario getScenario() {
        if (scenario == null) {
            scenario = new Scenario();
        }
        return scenario;
    }

    @Override
    public void addScenario(Scenario scenario) {
        this.scenario = scenario;
        if (scenario != null) {
            site.getScenarios().add(scenario);
        } else {
            throw new RuntimeException("Null Scenario");
        }
    }

    @Override
    public void addScenario(String scenarioName) {
        Scenario scenario = new Scenario(scenarioName);
        addScenario(scenario);
    }

    @Override
    public void addScenario(String scenarioName, String scenarioDescription) {
        Scenario scenario = new Scenario(scenarioName, scenarioDescription);
        addScenario(scenario);
    }

    @Override
    public void setScenarioDescription(String description) {
        getScenario().setDescription(description);
    }

    @Override
    public void addDependency(String dependency) {
        getScenario().getDependencies().add(new Dependency(dependency));
    }

    @Override
    public Page getPage() {
        return page;
    }

    @Override
    public Form getForm() {
        return form;
    }

    @Override
    public Unit getActiveUnit() {
        return activeUnit;
    }

    @Override
    public void setActiveUnit(Unit activeUnit) {
        this.activeUnit = activeUnit;
    }

    @Override
    public void addPage(Page page) {
        if (scenario != null && page != null) {
            this.page = page;
            setActiveUnit(page);
            scenario.getUnits().add(page);
        } else {
            throw new RuntimeException("Null Scenario or Page");
        }
    }

    @Override
    public void addForm(Form form) {
        if (scenario != null && form != null) {
            this.form = form;
            setActiveUnit(form);
            scenario.getUnits().add(form);
        } else {
            throw new RuntimeException("Null Scenario or Form");
        }
    }

    @Override
    public void addAction(Action action) {
        getActiveUnit().getActions().add(action);
    }

    @Override
    public Custom getCustom() {
        if (custom == null) {
            custom = new Custom();
        }
        return custom;
    }

    @Override
    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    @Override
    public void setCustom(String title) {
        getCustom().setTitle(title);
    }

    @Override
    public void addImport(Import anImport) {
        getCustom().addImport(anImport);
    }

    @Override
    public void addImport(String library) {
        getCustom().addImport(new Import(library));
    }

    @Override
    public void extend(String superClass) {
        getCustom().setSuperClass(new Extend(superClass));
    }

    @Override
    public void implement(String theInterface) {
        getCustom().addInterface(new Implement(theInterface));
    }

    @Override
    public void commitCustomAction() {
        getActiveUnit().getActions().add(custom);
    }

    @Override
    public void printData() {
        System.out.println("\nApp Data:");
        System.out.println(Collections.singletonList(Data.getData()));
        System.out.println("\nUser Data:");
        System.out.println(Collections.singletonList(Data.getUserData()));
        System.out.println("\nScenarios Status:");
        System.out.println(Collections.singletonList(Data.getScenariosStatus()));
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getTitle() {
        if (title == null) {
            title = fileName;
        }
        return title;
    }
}