#### V 3.7 [July 27, 2017]
* Introduce a new **IBridge interface and Bridge class** to connect any input interface
to the whole framework.
    * **Writer and Executer classes deprecated**, and instead the Bridge class can be extended
    to produce same functionality.
    * **Introduce XMLBridge** class to deal with xml input files.
    * All samples needs to be edited to work with the new version.
        * One sample added to the framework, all samples will be updated soon.
    * More Bridges can be easily integrated with framework.
* Many other minor changes.

#### V 3.6.1 - V 3.6.7:
* Improvement: check and create xml and reports folder if they not exists.
* Update: project description.
* Other minor changes and improvements.

#### V 3.6 [July 17, 2017] - First Public Release:
* **The Project source opened for public!**
* Samples removed, you still can access them by downloading them from the provided link (above).
* Features list added to the project description (above).
* Other minor changes and code cleanup.

#### V 3.5:
* **Extent Reporting System** used instead of our previous native reporting system, in order
to provide the team with advanced reports and visual data summaries.
    * Full features of Extent can be found at: http://extentreports.com/
    * All report samples updated to the new version of reports.
* Other minor changes.

#### V N3.4:
* Add **Scenario Dependencies** Feature: The user could add dependencies between scenarios,
so that the scenario which depend on another won't be executed unless the other one has been
succesfully executed without any failed steps.
* Other minor changes.

#### V N3.3:
* Errors catching and reporting at unit (page and form) level.
    * Errors catching at test file level still available and work.
* Other minor changes:
    * New Report sample illustrate error reporting at unit level added
    (guru99_UnitErrorCatch-...html).

#### V N3.2:
* Add **Extend** statement to the **custom code** action, using this action
the user could extend any Java class.
    * By default: Base framework class is inherited.
* Add **Implement** statement to the **custom code** action, using this action
the user could implement any Java interface.
    * The user could add as much as he wants implement actions.
    * The user 'at least currently' can not override interfaces' methods.
    * By default: No interfaces inherited.
* Other minor changes:
        * Redesign custom notes (in reports)
        * New samples added to (java com/abukhleif/akfnas/samples/reports/ xml files).

#### V N3.1 - N3.1.2:
* User can add **custom notes** to the report.
* Add **Import** statements to the **custom code** action.
* Other minor changes:
    * 'test' package renamed to '**com.abukhleif.nas.samples**'.
    * New samples added to (java samples/ reports/ xml files).

#### V N3.0.1:
* Code Cleanup.

#### V N3.0:
* Add **Custom** action, which enable the user (Tests File writer) to 
inject a java code and execute it directly in case of he/she did not find the
 feature he/she look about in our framework.
* Improve Report design.
* Improve Reporter and Base framework.
* Add Samples for the new feature (Custom Code injection) under Java Writer
and Executer classes, in addition to the generated xml file!
* Other minor changes.

#### V N2.10:
* **Step-By-Step Report Generation**, which guarantee writing the result in case of
 execution errors or exceptions. Error messages (causes) written to end of the
 report to state the error.
* Base framework code clean up.
* Other minor changes and bugs fixing.

#### V N2.9:
* Multiple Browsers Support:
    * Chrome [Tested]
    * FireFox
    * IE
    * HeadLess [Tested]

#### V N2.8:
* New (and better) **design** for reports.
* Reports titled with help of xml file name which used to run the samples in addition
to the date and time of the execution.
* **Click** and **Submit** actions appears in the final report.
* Other minor changes and bug fixing.
* In Pages and Forms, if both of url and relative attributes values are null 
(no values) resulting in staying at the same page or form and use all actions
of the unit (page or form). This can help in execute the scenarios in more
logical (natural) way, and generates more readable and natural reports.
* Other minor changes.

#### V 2.0, V1.9.2, V1.9.1:
* Minor changes and bugs fixing.

#### V1.9:
* **ChromeDriver** using **Maven** instead of include it in the project package.
* Other minor changes and bugs fixing.

#### V1.8:
* Changes in reports design.
* Other minor changes and bugs fixing.

#### V1.7.1:
* Minor changes and bugs fixing.

#### V1.7:
* Adding any action to an instance of Writer class results in adding it directly,
**no need for committing each group of actions** separately.
* Other minor changes and bugs fixing.

#### V1.6:
* Fix FillElement action reading process from stored data.
* Add **VerifyAlert** and **RespondAlert** actions which helps in dealing with
popup alerts from websites.
* Form **Submit** action supports both submitting by the submit method via any
form element, or via clicking a button.
* Rename actions: (Text --> **VerifyText**, NotText --> **VerifyNotText**).
* **Reporter** (renamed from Reportable) class can be used by any class without
the need to extend it, all classes will accesses one shared copy of the
Reporter instance.
* Add **WriterTester** and **ExecuterTester** to help in generate and execute
XML files via Java code.
* Other minor changes and bugs fixing.

#### V1.5:
* New (and better) **design** for reports.
* Add Form **Submit** as a new action, this will help in execute other actions
and/or verifications either before or after the form submit action.
* **Header** and **Footers** added to the **reports**, for entering the main site, and for
each page and form, so the QA can easily read the results (from the report) in its natural order
including the actions resulting in each group of verification results.
* **Relative** attribute added to both of **Page** and **Form**, setting this
 attribute to "yes" results in combine the main site URL, the slash sign (/),
 and current page or form url. On the other hand, the QA still have the ability
 to use static URLs via setting this attribute to "no".
* **CSS** is now the only used way to design report rows, instead of some
deprecated html tags.
* Other minor changes and bugs fixing.

#### V1.4:
* Add **Click** .action.
* Add **ClickCheckbox** action.
* Add **FillElement** action, to fill text input fields.
* Add **Store** action, this .action help the user (QA) to store any cdata from
the web page/form and use it anywhere during the samples.
* Add **ManualStore** action, this action help the user (QA) to store any
useful data and use it anywhere during the samples.
* Update **Data** class to store data via Store and ManualStore actions, 
in addition to other data.
* Add **Text** action, this action verifies if the page contain this text.
* Add **NotText** action, this action verifies if the page does not contain
this text, useful for error messages discovering.
* Add **Select** action, to select any option from a dropDown (or dropUp) menu.
* A new **DriverUtils** class added and used in find web elements in all possible
ways using single attribute (id).
* Reports redesign.
* Add **Form** unit. All actions can completely work with forms as pages. 
* Add **Unit** class which the Form and Page classes extend to apply
 polymorphism principles.
* Update **Site** scope class, and add name and url properties to it.
* Other minor changes and bugs fixing.

#### V1.3:
* Add **Data** to store data, both the data stored by the user, and some
other needed data like the main site url.
* Other minor changes and bugs fixing.

#### V1.2:
* Add **Action** abstract class, all actions extend this class, each page now
has only to have a list of actions, not a list for each action type,
 this also help in conserve the natural order of actions and applying polymorphism. 
* Add **Scope** abstract class, all scopes extend this class.
* Delete Action and Scope interfaces due to incompatibility between Selenium WebDriver
and Interfaces!
* Update **Page** unit, and add **Parse** method to execute all children
actions of the page.
* Update **Scenario** scope class.
* Add Main **Site** scope class.
* Other minor changes and bugs fixing.

#### V1.1:
* Add **Reportable** class.
* Update **Base** Framework.
* Update **Page** unit.
* Add **Action Interface**.
* All Actions added but not yet implemented.
* Add **Page** unit.
* Add **Scenario** scope.
* Add **Scope** interface.
* Other minor changes and bugs fixing.

##### V1.0:
* Initial Release.