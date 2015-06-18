/**
 * Technical documentation regarding the user story ipc01_01: start sharing.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Implement a mechanism to establish secure communications (encrypted) between
 * cleansheets instances. To test the infrastructure must implement a simple
 * sidebar window that lists all other instances found on the net. Instances
 * must have a name (which must be unique, or should be concatenated with the IP
 * address).
 * <br/>
 * <br/>
 * <b>Use Case "Secure Comunication":</b>
 * The user selects the sidebar. Then begins the process of searching other
 * online user. The system displays a list of users to which it can connect. The
 * user selects customer that he wants to comunicate and the system sends the
 * message.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * It will be necessary study how to add a new sidebar to the design. Since the
 * search server protocol (UDP) is already implemented, it's only necessary to
 * study how to send encrypted data using SSL. TCP protocol is already
 * implemented to comunicate between instances so it can be used as example.
 * <br/>
 * <br>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/ipc_06_01_analysis.png"/>
 * <br/>
 * <br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able communicate using SSL connection
 * with other instances of "CleanSheets". </br>
 * This test is funcional:</br> 
 * - Enable secure connections in two or more computers (Extensions Menu-> Secure
 * Comunication -> Start SSLServer </br>
 * - Then go to sidebar and choose a * instance </br>
 * - double click on instance and connect </br>
 * - a message will appear  * on the screen with the information (success or failed)</br>
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * Extension Setup </br>
 * <img src="doc-files/ipc_06_01_extension_setup>
 *
 * Menu Setup </br>
 *
 * SideBar Setup </br>
 *
 *
 */
package csheets.userstories.ipc06_01.secure_comunication.i130616;

/**
 *
 * @author rddm (1130616)
 */
class _Dummy_ {
}
