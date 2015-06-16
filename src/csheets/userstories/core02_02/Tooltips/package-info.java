/**
 * Technical documentation regarding the user story core02_02: tooltips and association of the user to the commentary. 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * If a cell as at least one commentary (the multiple commentaries must be supported), the user should be able to see the commentaries as a tooltip. The 
 * username of the author of the commentary must be associated.
 * <br/>
 * <br/>
 * <b>Use Case "Tooltip and association of the user to the commentary":
 * </b> 
 * The user  passes the mouse above a cell. If the cell as at least a commentary 
 * it must appear to the user as a tooltip. 
 * The author of the commentary must be presented<br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * 
 * This use case will be implemented as a continuation of the comments on cells
 * extension (see documentation of core 02.01). The comments will be presented
 * as a tooltip if the mouse passes over the cell hosting it. The method setToolTipText
 * will be used in this project
 * </br>
 * </br>
 * <code>cell.setToolTipText("Comment text");</code>
 * </br>
 * </br>
 * The author of the commentary (last one that edited ) will appear in the
 * end of the tooltip text. The author name will be the one associated with the computer used
 * to edit/create the commentary.
 * <br/>
 * <br/>
 *  <code>String username = System.getProperty("user.name");</code>
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).<br/> 
 * <br/>
 * <img src="doc-files/comments_extension_uc_realization1.png"> 
 * <br/> 
 * <br/>
 * From the previous diagram we see that we need to add the compatibility to multiple comments in a single cell.<br/>
 * The addition of a single comment to a cell was alrealdy studied in the use case core 02.01.
 * </br>
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application <a href="../../../../overview-summary.html#modelo_de_dominio">here</a><br/>
 * From the domain model we see that there is a Cell interface. This defines the interface of the cells. We also see that there is a class CellImpl that must implement the Cell interface.<br/>
 * If we open the {@link csheets.core.Cell} code we see that the interface is defined as: <code>public interface Cell extends Comparable &lt;Cell&gt;, Extensible&lt;Cell&gt;, Serializable</code>. Because of the <code>Extensible</code> it seams that a cell can be extended.<br/>
 * If we further investigate the hierarchy of {@link csheets.core.Cell} we see that it has a subclass {@link csheets.ext.CellExtension} which has a subclass {@link csheets.ext.style.StylableCell}. {@link csheets.ext.style.StylableCell} seems to be an example of how to extend cells.<br/>
 * Therefore, we will assume that it is possible to extend cells and start to implement tests for this use case. <br/>
 * <br/>
 * The <a href="http://en.wikipedia.org/wiki/Delegation_pattern">delegation design pattern</a> is used in the cell extension mechanism of cleansheets. The following class diagram depicts the relations between classes in the "Cell" hierarchy.<br/> 
 * <img src="doc-files/core02_01_analysis_cell_delegate.png"> 
 * <br/>
 * 
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:<br/>
 * <pre>
 * {@code 
 * 	public Cell getExtension(String name) {
 *		// Looks for an existing cell extension
 *		CellExtension extension = extensions.get(name);
 *		if (extension == null) {
 *			// Creates a new cell extension
 *			Extension x = ExtensionManager.getInstance().getExtension(name);
 *			if (x != null) {
 *				extension = x.extend(this);
 *				if (extension != null)
 *					extensions.put(name, extension);
 *			}
 *		}
 *		return extension;
 *	}
 * }
 * </pre>
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at 
 * the moment and then returned. The extension class (that implements the <code>Extension</code> interface)
 * what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). 
 * The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). 
 * For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method 
 * invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.<br/>
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.<br/> 
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core functionality of 
 * this use case is to be able to store multiple comments/texts and show this information as a tooltip. <br/>
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). 
 * A test can be set to add two commentaries to a cell and test if the get method returns the same Strings.<br/>
 * Finnaly we must test if the name of user is equal to the one in the computer system.
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end.<br> 
 * <br/>
 * see: <code>csheets.ext.comments.TooltipsTest</code><br/>
 * 
 * <h2>4. Design</h2>
 * To realize this user story we will need to support multiple users, comment's author and set a tooltip in the CommentableCellDecorator.
 * <br/>
 * The following diagrams illustrate core aspects of the design of the commnet's cells.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when cleansheets is run.<br/><br/>
 * <img> src="doc-files/core02_02_design.png"</img>
 * <br/>
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell. The idea is that when this happens the extension must display in the sidebar the comment of that cell (if it exists).<br/> 
 * <br/>
 * <img> src="doc-files/core02_02_design2.png"</img>
 * <br/>
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the 
 * text of the comment of the current cell. To be noticed that this diagram does not
 * depict the actual selection of a cell (that is illustrated in the previous diagram).<br/>
 * <br/>
 * <img> src="doc-files/core02_02_design3.png"</img>
 * 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * As an extra this use case also implements a small cell visual decorator 
 * if the cell has a comment. This "feature" is not documented in this page.<br/>
 * <br/>
 * <br/>
 * 
 * @author i130395
 */

package csheets.userstories.core02_02.Tooltips;

/**
 * 
 * 
 * @author 1130395
 */
class _ToolTips_ {}

