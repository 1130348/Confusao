/**
 * Technical documentation regarding the user story ipc07_01: select game and
 * partner.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * The purpose of this use case is making an extension that allows two instances
 * of cleansheets establish a connection to play games. Each instance should see
 * two options to play: naval battle and game of checkers. They should agree to
 * play one of the games. Each user must set their name and image to be
 * transmitted to another instance. The user may be able to play multiple games
 * at the same time. There should be one sidebar that lists the active games. It
 * should be possible to give up the game.
 * <br/>
 * <br/>
 * <b>Use Case "Select game and partner":</b>
 * The user starts the games extension and the system displays a list of
 * instances currently available for the connection. The user chooses the
 * partner with whom he wants to play. The system has two possible games,
 * including the checkers game and the naval battle game. The user selects the
 * game that he wants to play, this must be agreed by both. The system asks each
 * user name and image. The user enters their name and choose an image within
 * possible image list and the game starts.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In order to make connection between players it is necessary understand the
 * communication process through the UDP/TCP protocol. It will also be necessary
 * to understand how the sidebars work in order to list active games of each
 * instance at the moment. In addition to the previous it's also fundamental
 * study the operation of networks and the definition of gateways.
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
 * <img src="doc-files/draft_ipc_07_01.png"/>
 * <br/>
 * Through the earlier draft we can see that the class GameConnection was
 * created. This class have the responsibilities of connect both clients and the
 * tranmission of the user info. In addition we will need to study how to search
 * ​​for others instances of "CleanSheets" on the same local network.
 * <br/>
 * <br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * The core technical problem remains on the connection to another instance and
 * the transmission of the user data. We must have a default port attribute in
 * class GameConnect in order to connect to another instance. In addition each
 * instance of "CleanSheets" will transmit his own information to other
 * "CleanSheets", for it will then be necessary to construct a method that
 * establishes the connection and another method to transmit the user info.
 * Finally the problem remains on the possibility that the user have to play
 * several games at once and the list of active games.
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from the requirements and analysis we revealed that the main
 * feature of this use case is to be able to start the connection between two
 * users in order to play a games, we can start by coding a unit test that uses
 * a new attribute to the name and image with the corresponding accessor methods
 * (set and get). A simple test to set this attribute with one point to see if
 * the get method returns the same data. In another approach we can functionally
 * test whether another instance of the "CleanSheets" after connecting receives
 * the user information transmitted by the other instance, and another test to
 * verify if the ative games are listed in sidebar.<br/>
 * <br/>
 * see:
 * <code>csheets.ext.select_game_and_partner.SelectGameAndPartnerTest</code><br/>
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. In the code of the
 * extension <code>csheets.ext.style</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Start Sharing" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/Extension_setup_ipc_01_01.png"/>
 * <br/>
 * <h3>User Select Cells And Clicks Botton To Send</h3>
 * The following diagram illustrates what happens when the user select cells.
 * When the user selects the cells the object StartSharingAction has access to
 * SpreedSheatTable who knows the user selected cells. After the user selected
 * cells, he press the button to send and active actionPerformed() method of
 * class StartSharingAction<br/>
 * <br/>
 * <img src="doc-files/select_cells_and_click_ipc_01_01.png">
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.startsharing</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.startsharing.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * We cant achieve the objectives because we have a problem with ports<br/>
 * <br/>
 * <br/>
 *
 */
package csheets.userstories.ipc07_01.select_game_and_partner.i130399;

/**
 *
 * @author Sérgio Gomes (1130399)
 */
class _Dummy_ {
}
