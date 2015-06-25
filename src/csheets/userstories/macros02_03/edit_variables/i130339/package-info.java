/**
 * Technical documentation regarding the user story macros02.03: Edit Variables
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Should exist a sidebar to consult and to edit de values of the variables. When a variable is selected must appear automatically which cells use it (for containing references on the formula). Because of that when the formula is changed that window should be update.
 * <br/>
 * <br/>
 * <b>Use Case "Edit variables":</b> <br/>The user begins by choosing a variable to edit or to consult. When the variable is selected will appear on the sidebar all the cells that use the choosen variable. If the user opted by changing the value of the variable all the cells that use it will be changed too.
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created). 
 * <br/> The user will need to select a variable. In order to the user select one variable and to the list has some to choose it is necessary to exists at least one variable. After selecting the variable that wants to consult or to edit all the cells where is used will be showed. At this moment, the user can change the value of the variable and all the cells will be updated.
 * <br/>Let's now see the ssd for this use case.
 * <br/><br/>
 * <img src = "doc-files/macros02_03_ssd.png"/>
 * <br/><br/>
 * The controller class (EditVariablesController) will have a method that retorns a list of address when the variable passed by parameter (probably getAddressVariable(String var)). And will have the method modifications to know if any formula had changed. If positive, the list of varaibles will be updated.
 * <br/> Let's now see the sequence diagram from Analysis. 
 * <br/><br/>
 * <img src = "doc-files/macros02_03_analysis_sequence.png"/>
 * <br/><br/>
 * <br/><br/>
 * <img src = "doc-files/macros02_03_class_diagram_analysis.png"/>
 * <br/><br/>
 *   
 * <h3>Analysis of Core Technical Problem</h3>
 * The idea is to create a sidebar with a comboBox that will have all the variables created on the sheets.
 * Besides will be two buttons: Refresh and View. The Refresh Button will refresh the variables on the list so if the user insert a new variable on the cells and wants to see it on the list needs to refresh. The other button, View, will show the user all the cells where the variable is referenced (a list of Cells on the bottom of the sidebar).
 * <br/> On the midle of the sidebar will be a JTextField showing the actual value of the variable and allowing the user to change. 
 * 
 * <h2>3. Tests</h2>
 * For this use case, there will be a few unitary tests, since all the methods that are used
 * in this UC were already implemented in the original program, so i assume that the given
 * code was correct, even without having tests, since who made the program didnt do a approach 
 * based on tests.
 * <br/>
 * The method that needs to have an unitary test is getAddressVariable() to test if the looking for the references of the variables is correct.
 * see: <code>csheets.ext.macros02_03.edit_variables.EditVariablesControllerTest</code><br/>
 * 
 * <h2>4. Design</h2>
 *
 * Here we can see the sequence diagram to go get the variables
 * <br/><br/>
 * <img src = "doc-files/macros02_03_sequence_diagram_design_getVariables.png"/>
 * <br/><br/>
 * 
 * After that if the user chooses a variable, it will be necessary to go get the value and the cells where the
 * variable is used.
 * 
 * <br/><br/>
 * <img src = "doc-files/macros02_03_sequence_diagram_design_getValueandCellsfromVar.png"/>
 * <br/><br/>
 * 
 * Here is the diagram for the method getAddressVariable 
 * 
 * <br/><br/>
 * <img src = "doc-files/macros02_03_sequence_diagram_design_getAddressVariable.png"/>
 * <br/><br/>
 * 
 * <h2>5. Coding</h2>

 * <h2>6. Final Remarks</h2>
 * 
 *
 * @author António Pinheiro <1130339@isep.ipp.pt>
 */
package csheets.userstories.macros02_03.edit_variables.i130339;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author António Pinheiro
 */
class _Edit_Variables_ {
}
