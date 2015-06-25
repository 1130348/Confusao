/**
 * Technical documentation regarding the user story ipc05.2: find participants
 * extensions.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Provide a new functionality allowing find Cleansheets instances in the local
 * network (possible chat participants). Must be possible to set an icon (e.g. a
 * picture) for each participant as a message and a state. All messages must be
 * saved by the system.
 *
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * User Story Core01.1 aims to make it easier find other partcipants in the
 * Local Network<br />
 * We will use the extensions in the use case Ipc 05.1 and add the possibility
 * to find all the other user which has the active chat.
 * <br/>
 *
 * <h2>3. Tests</h2>
 * In this use case decided to apply only functional testing because it takes at
 * least two or three instances of Cleansheets to show whether the program is
 * showing all the users that are active.
 * <br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to add a new feature to the send
 * message extension and a new Button in the MessageExtensionUI. We will also
 * need to create a sidebar to show all the users. The following diagrams
 * illustrate core aspects of the design of the solution for this use case.<br/>
 * <img src="doc-files/ipc_05.2_design.png">
 *
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <h3>Modified</h3>
 * <a href="../../../../csheets/ext/Send_Message/package-summary.html">csheets.ext.Send_Message</a><br/>
 * <a href="../../../../csheets/ext/Send_Message/ui/package-summary.html">csheets.ext.Send_Message.ui</a>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1091334
 */
package csheets.userstories.ipc05_02.find_participants;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1091334
 *
 */
class _Dummy_ {
}
