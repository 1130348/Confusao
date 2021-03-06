/**
 * Technical documentation regarding the user story core01_1: enable/disable
 * extensions.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Provide a window to allow enable and disable cleansheets extensions. It
 * should also be a sidebar window "Navigator" to submit extensions (enable and
 * disable) .
 * <br/>
 * <br/>
 * <b>Use Case "Enable/Disable":</b> The user selects the extension on the
 * "Navigator" tab where he can disable or enable the extension desired.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * User Story Core01.1 aims to organize the extensions in the application.<br />
 * The application will have a SideBar "Navigator" that will show the user all
 * the extensions and will give the possibility to change the status
 * (enable/disable) of the extension. The extensions that received an status
 * change to disabled will appear "locked" and if enable will allow the use of
 * it.r For the development of the this feature we will use some classes that
 * already exist like "ExtensionManager" and "Extension" and their properties.
 * <br/>
 *
 * <h2>a) First Sequence Diagram</h2>
 * <img src="doc-files/core01_01_enable_disable_ext_design_analysis.png">
 *
 * * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to enable/disable extensions. We
 * need to be able to set and get the status value from the desired
 * extensions.<br/>
 * Following this approach we can start by coding a unit test that uses the
 * class <code>Extension</code> with a new attribute "status" to enable or
 * disable the extension with the corresponding method accessors
 * (defineStatus()-> set; Status()->get). A simple test can be to set this
 * attribute with a simple boolean and to verify if the get method returns the
 * same boolean.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.ext.ExtensionTest</code><br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.Enable_Disable</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 * <img src="doc-files/core01_01_enable_disable_ext_design1.png">
 *
 * <img src="doc-files/core01_01_enable_disable_ext_design2.png">
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.Enable_Disable</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.Enable_Disable.ui</a>
 *
 * <h3>Modified</h3>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ui</a><br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ui.ext</a>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1091334
 *
 */
package csheets.userstories.core01_01.enable_disable_ext.i091334;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1091334
 *
 */
class _Dummy_ {
}
