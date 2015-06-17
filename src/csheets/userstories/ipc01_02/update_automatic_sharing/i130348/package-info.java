/**
 * Technical documentation regarding the user story ipc01_02: Update automatic sharing.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Allow connect to another instance of cleansheets and send cells
 * for that instance, right after input and start the same proccess in the other instance. 
 * The received content should be presented in the same
 * "local" and with the same formatation. For this, we're gonna use ipc01.1 to connect to other instances.
 * Regarding the ui, it's also going to look almost the same as ipc01.1, with a different text info.
 * <br/>
 * <br/>
 * <b>Use Case "Update Automatic Sharing":</b>
 * As in ipc01.1, the user selects the port and search for other instances in the same Network(LAN),
 * after choosing the instance that he wants to connect, the user clicks on the connect button and start the automatic sharing.
 * To use this feature, the user needs to changes the cell value, that is send automatically to the other instance.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In ipc01.1 we already connect to the other instance, now we need to study
 * the cells in order to automatically send their content. Be aware, that in this use case
 * it's necessary to send the formatation of the cell aswell.
 * Although we already have a connection, we need to transmit to the our instance also,
 * using the same ideia as the connection used in ipc01.1.
 * <br/>
 * <br/>
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
 * <img src="doc-files/ipc01_02_analysis.png"/>
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to add a new "attribute" to a
 * cell: "comment".<br/>
 * Therefore, at this point, we need to study how to add this new attribute to
 * the class/interface "cell". This is the core technical problem regarding this
 * issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application
 * <a href="../../../../overview-summary.html#modelo_de_dominio">here</a><br/>
 * From the domain model we see that there is a Cell interface. This defines the
 * interface of the cells. We also see that there is a class CellImpl that must
 * implement the Cell interface.<br/>
 * If we open the {@link csheets.core.Cell} code we see that the interface is
 * defined as:
 * <code>public interface Cell extends Comparable &lt;Cell&gt;, Extensible&lt;Cell&gt;, Serializable</code>.
 * Because of the <code>Extensible</code> it seams that a cell can be
 * extended.<br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able communicate with other instances
 * of "CleanSheets" and send them automatically the content of the cells.<br/>
 * As the connection was developed in ipc01.1, the connection tests are already done.
 * Now we need to focus on the content we are sending and if it's being received 
 * on the other instance.
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.ext.start_sharing.StartSharingTest</code><br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. In the code of the
 * extension <code>csheets.ext.style</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Start automatic Sharing" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/Extension_setup_ipc_01_01.png"/>
 * <br/>
 * <h3>User Changes Cells Value</h3>
 * The following diagram illustrates what happens when the user changes cells value.
 * When the user changes cells value, the object Network has access to
 * the changed cell, and sends it automatically to other instances.<br/>
 * <br/>
 * <img src="doc-files/select_cells_and_click_ipc_01_01.png">
 *
 */
package csheets.userstories.ipc01_02.update_automatic_sharing.i130348;

/**
 *
 * @author Egidio Santos
 */
class _Dummy_ {
}
