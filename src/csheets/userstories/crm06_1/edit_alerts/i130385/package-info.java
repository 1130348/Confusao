/**
 * Technical documentation regarding the user story macros06_01: edit alerts. 
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * The purpose of this use case is to provide the Cleansheets user with the
 * possibility to create alerts. Each alert has a name, a description and a
 * timestamp. When the alert's timestamp equals the system's timestamp a popup
 * window appears to remind the user of the alert. The popup window must contain
 * the name and the description of the alert and a button that gives the user
 * the option to postpone the alert by 5 minutes. It should also be possible to
 * create an alert when creating an event.
 * <br/>
 * <br/>
 * <b>Use Case "Edit Alerts":</b>
 * The user starts the alert creation. He enters the name, description and
 * timestamp of the alert. He then clicks on the option to create an alert and
 * the alert is added to the list of current alerts. He can also edit or remove
 * an alert.
 * <br/>
 * <br/> 
 * <h2>2. Analysis</h2>
 * The key to implementing alerts correctly has all to do with timestamps. The
 * major concept one must have in mind when implementing alerts is that the
 * alert will be prompted when its timestamp is the same as the system's current
 * timestamp. This will have to be implemented using threads so that each alert
 * execution does not block the program's execution flow thus locking access to
 * other Cleansheets functionalities in the process.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the 
 * previously described use case. We call this diagram an "analysis" use case 
 * realization because it functions like a draft that we can do during analysis 
 * or early design in order to get a previous approach to the design. For this 
 * reason we mark the elements of the diagram with the stereotype "analysis" 
 * which states that the element is not a design element and, therefore, does 
 * not exist as such in the code of the application (at least at the moment 
 * that this diagram was created).<br/> 
 * <br/>
 * <img src="doc-files/edit_alerts_analysis_diagram.png"/>
 * <br/>
 * Through this early draft we can see that the class AlertsList will be
 * responsible for storing all the created alerts. It will have an alert
 * container, most probably a list.
 * <br/>
 * <h3>Analysis of The Core Technical Problem</h3>
 * The core technical problem lies within the firing of the alerts. It will be
 * necessary to implement a thread that checks whether or not the alert's
 * timestamp corresponds to the system's timestamp.
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core 
 * functionality of this use case is to be able to create, edit and remove
 * alerts.
 * <br/>
 * In regards to the unit tests of this use case we will be testing the class
 * <code>EditAlertsList</code> which will hold all responsibilities that have to
 * do with alerts. We will be primarily testing the method 
 * <code>validadeCalendar</code> since the other methods in this class are
 * very similar to getters and setters and thus require no testing.
 * <br/>
 * <h2>4. Design</h2>
 * To realize this user story we will need to extend the class Extension since
 * we want to create a new extension for CleanSheets. We will also need to 
 * create a subclass of UIExtension. In the code of the extension 
 * <code>csheets.ext.style</code> we can find examples that illustrate how to
 * implement these technical requirements.
 * <br/>
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.
 * <br/>
 * <h3>Alert creation, edition and removal</h3>
 * The following diagram illustrates what happens when the user creates, edits
 * or removes an alert.
 * <br/>
 * <br/>
 * <img src="doc-files/edit_alerts_design_sequence_diagram.png"/>
 */


package csheets.userstories.crm06_1.edit_alerts.i130385;

/**
 *
 * @author João Paiva (1130385)
 */
class _Dummy_ {}


