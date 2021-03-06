# NAS (Native Automation System) by AKF | V 3.7
An advanced -OPEN SOURCE- automation framework (based on Selenium) with custom code injection ability. Developed by AKF (AbuKhleif). 

## Main Features:
* Test File Hierarchy:
    * Site: Main site [The only unique block]
        * Scenario
            * Unit: [Page] or [Form]
                * [Actions]
            * Unit
                * [Actions]
            * ...
        * Scenario
            * Unit
                * [Actions]
            * ...
        * ...
   
   Note: Site, Scenario, and units support dealing with null values in case the user does not need
      to deal with (some of) their properties. Provided samples can illustrate some of these cases.
      
* Supported Actions:
    * Main Actions:
        * Click: Click any button.
            * All possibilities to choose the elements (id, name, XPath, etc..) are supported by
             a unique identifier [id], the same for unit [Page/Form] urls. 
        * Click Checkbox: Click any checkbox (limited).
        * Fill Element: fill any input field.
        * Store: Store data from any web page for later uses.
        * Manual Store: Store any data for later uses [entered manually by user].
        * Respond Alert: Respond to any web alert with accept or deny.
        * Select: Select an element from a dropdown (or drop up) (limited).
        * VerifyText: Verify if the page contains a text.
        * VerifyNotText: Verify if the page does not contains a text.
            * Useful with error pages.
        * VerifyAlert: Verify the text of an alert.
        
    * Advanced Actions:
        * **Custom**: Gives the user the ability to inject the scenarios with custom Java code, for any reason
        or unsupported features in the framework. The injected code will be compiled and executed
        at runtime (using the src/com/abukhleif/akfnas/runtime package classes). Additional actions with custom code:
            * **Import**: Allows the user to add any number of imports statement to his/her custom code.
            * **Extend**: Allows the user to inherit any superclass.
                * By default: our base framework is inherited.
            * **Implement**: Allow the user to implements any interface.
                * [Limited]: The user can not override or add any methods [at least for now].
        * **Submit**: Allows the user to submit the form any time, and do any other actions either
        before or after submitting the form.
            * Both Submit by click a button or by using any form element are supported.
        * **Note**: Allows the user to add custom notes to the final report.
        
* **Advanced Reporting System**: the Extent framework is used for reporting every step in the scenarios.
    * Each scenario has a separated section for its steps.
    * Each step can have one of these statuses:
        * Pass: Step passed.
        * Fail: Step failed.
        * Skip: Step skipped.
        * Fatal: Step has an exception.
        * Note: Step contains an info and not a test.
    * Each scenario can have one of these statuses:
        * Pass: All steps passed [or info].
        * Skip:
            * At least, one step passed, the other steps passed [or info]. OR:
            * The scenario is depend on a previous failed or skipped scenario.
        * Fail: At least, one step is failed, the other can be passed, skipped, or info.
        * Fatal: At least, one step has a fatal error.
    * Full features of the reporting framework can be found at: http://extentreports.com
        
* **Dependencies between Scenarios**: Each scenario can depend on one or many previous scenarios, so 
 that the scenario will be skipped in case of at least on dependency failed or skipped.
 
* **Multiple Browsers Supported** to run tests:
     * Chrome [Tested]
     * FireFox
     * IE
     * HeadLess [Tested]
     
* **Easy Integration** with other applications: all actions are supported and can be used via the
'midtier' package, which contain 2 classes:
    * Writer: Can be used for writing tests in Java, and generate the XML file.
        * The user can -directly- write his/her own xml file too.
    * Executer: Which can be used to execute any XML tests file.
    
* **Manual Written or Java Generated XML Test Files**:  The user can write his/her XML tests file, 
or write the Java code for testing (using the scr/com/abukhleif/akfnas/midtier/Writer class), then execute the result file
-in both cases- (using the src/com/abukhleif/akfnas/midtier/Executer class).
        
* Built with Polymorphism and other OO principals in mind. 
* Samples provided for a quick start using the framework.
* Explore the rest yourself.

## Run and Testing: [Need to be updated to work with V 3.7]
* Project includes many sample files which can be used as a reference or a guide
to help you write your own files.
* Project also includes the Java classes which used to generate the samples files,
 you can also use them as a guide if you prefer to write your samples files using
 Java instead of XML, and adding one command will take the responsibility of
 converting your Java code to XML file.
* ExecuterTester Class is an example of how can the files tests
executed, you can create your own class or just use it as is.
* Reports are the final results, each test will generate a report to display
the results.

### Samples: [Need to be updated to work with V 3.7]
* All Samples can be found at: http://www.abukhleif.com/projects-data/AKF-NAS/samples/
    * Java Samples: Contains the Java Classes which used to generate the XML test files.
    * XML: XML test file samples.
    * Reports: all generated reports after run each of the previous xml tests file.
        
### TECHNOLOGIES USED:
* Java (with IntelliJ IDEA IDE)
* Jaxb (XML Parsing Library)
* Maven
* Selenium Webdriver
* Extent (Reporting Library)


#### Please check out the change log [CHANGELOG.md] file for more details.