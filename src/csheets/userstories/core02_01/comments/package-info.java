/**
 * Technical documentation regarding the user story core02_01: comments on cells. 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * Setup extension for comments on cells. The user should be able to activate and deactivate comments on cells. When activated, a sidebar for the comments should appear. The sidebar should be composed of a simple textbox to display and edit a comment. At the moment it is not required to save comments to disk.
 * <br/>
 * <br/>
 * <b>Use Case "Enter Comment on Cell":</b> The user selects the cell where he/she wants to enter a comment. The system displays the current comment of that cell. The user enter the text of the comment (or alters the existing one). The system saves the comment of the cell.<br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * Since comments on cells will be supported in a new extension to cleansheets we need to study how extensions are loaded by cleansheets and how they work.<br/> 
 * The first sequence diagram in the section <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application Startup</a> tells us that extensions must be subclasses of the Extension abstract class and need to be registered in special files.<br/>
 * The Extension class has a method called getUIExtension that should be implemented and return an instance of a class that is a subclass of UIExtension.<br/>
 * In this subclass of UIExtension there is a method (getSideBar) that returns the sidebar for the extension. A sidebar is a JPanel.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).<br/> 
 * <br/>
 * <img src="doc-files/comments_extension_uc_realization1.png"> 
 * <br/> 
 * <br/>
 * From the previous diagram we see that we need to add a new "attribute" to a cell: "comment".<br/>
 * Therefore, at this point, we need to study how to add this new attribute to the class/interface "cell". This is the core technical problem regarding this issue.<br/>
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
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at the moment and then returned. The extension class (that implements the <code>Extension</code> interface) what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.<br/>
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.<br/> 
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to add an attribute to cells to be used to store a comment/text. We need to be able to set and get its value.<br/>
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). A simple test can be to set this attribute with a simple string and to verify if the get method returns the same string.<br/>
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end.<br> 
 * <br/>
 * see: <code>csheets.ext.comments.CommentableCellTest</code><br/>
 * 
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We will also need to create a subclass of UIExtension. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution for this use case.<br/>
 * 
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!</br> 
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when cleansheets is run.<br/><br/>
 * <img src="doc-files/core02_01_design.png">
 * <br/>
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell. The idea is that when this happens the extension must display in the sidebar the comment of that cell (if it exists).<br/> 
 * <br/>
 * <img src="doc-files/core02_01_design2.png">
 * <br/>
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text of the comment of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).<br/>
 * <br/>
 * <img src="doc-files/core02_01_design3.png">
 * 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.<br/>
 * <br/>
 * <br/>
 * 
 * @author alexandrebraganca
 */

package csheets.userstories.core02_01.comments;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

