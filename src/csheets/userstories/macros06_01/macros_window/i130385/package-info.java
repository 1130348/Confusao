/**
 * Technical documentation regarding the user story macros06_01: macros window. 
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * The purpose of this use case is to have a window that provides an option to 
 * create and run macros. These macros are composed of either formulas or 
 * comments. The formulas are the same formulas used within spreadsheet cells. 
 * To fulfill such requirements, a new grammar, similar to the already existing 
 * ones, should be added to the CleanSheets application.
 * <br/>
 * <br/>
 * <b>Use Case "Macros Window":</b>
 * The user opens the macros window. From here on out he can either create a new
 * macro, select a pre-existing one, or cancel the macro creating process.
 * Although there is an option to select an existing macro, it is not the
 * purpose of this use case to implement a persistance mechanism that saves
 * created macros between sessions, thus it will only be possible to load macros
 * created in the same CleanSheets session. Prior to creating a macro there are 
 * several options that a user should contemplate. These are, respectively,
 * selecting and adding a function from a list of available CleanSheets
 * functions, adding an operation, assigning a variable or writing a comment.
 * After the macro is created, it can be run or saved for later use. A name
 * should be provided to allow the identification of the macro. After running
 * the macro its output will be displayed (the output corresponds to the last
 * instruction in the macro, excluding comments).
 * <br/>
 * <br/> 
 * <h2>2. Analysis</h2>
 * In order to implement macro creation it is first necessary to understand how
 * functions, formulas and grammars have been implemented inside the CleanSheets
 * application. Since macros creation consists, at least during this stage, only
 * in a sequence of formulas that will be executed by order, it is a good idea
 * to know, beforehand, what a formula consists of. In our use case our formula
 * concept will cover functions, variable assignments and operations.
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
 * <img src="doc-files/macros_window_analysis_diagram.png"/>
 * <br/>
 * Through this early draft we can see where we will be retrieving our functions
 * list from and the global aspect of our use case.
 * <br/>
 * <br/> 
 * <h3>Analysis of The Core Technical Problem</h3>
 * The core technical problem for this use case will be understanding how to run
 * macros, correctly defining the too embracing formula concept to a more narrow
 * and objective definition and understanding how grammars are stored and
 * compiled inside the CleanSheets application.
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core 
 * functionality of this use case is to create macros.
 * <br/>
 * Because we are reusing model classes from previous use cases there is no need
 * to implement new unit tests. There will be, however, inumerous functional 
 * tests. These tests consist, mainly, of ensuring that the formulas added to
 * the macros produce the expected result. For example, adding the following
 * formula "SUM(5;3)" should produce the output of 8. Functional tests were also
 * applied to the user interface to make sure that there would be no bugs.
 * <br/>
 * <h2>4. Design</h2>
 * To realize this user story we will be mainly altering ui classes since the
 * model ones already exist.
 * <br/>
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.
 * <br/>
 * <h3>Create macros</h3>
 * The following diagram illustrates what happens when the user creates a macro.
 * On the main application frame under the menu Extensions there is a menu item
 * "Macro". When clicked this will prompt another menu item called "Create
 * Macro..." that when clicked will start this use case. The use case starts by
 * retrieving a list of all available functions. Afterwards, the user customizes
 * his macro. He can then decide to run it as it is shown in the
 * runButtonActionPerformed(). This proccess is explained detailedly on the
 * following sequence diagram.
 * <br/>
 * <br/>
 * <img src="doc-files/macros_window_design_sequence_diagram.png"/>
 */

package csheets.userstories.macros06_01.macros_window.i130385;

/**
 *
 * @author João Paiva (1130385)
 */
class _Dummy_ {}


