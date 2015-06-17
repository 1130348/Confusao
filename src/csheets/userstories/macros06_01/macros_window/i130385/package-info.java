/**
 * Technical documentation regarding the user story macros06_01: macros window. 
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * The purpose of this use case is to have a window that provides an option to 
 * create and run macros. These macros are composed of either formulas or 
 * comments. The formulas are the same formulas used within spreadsheet cells. 
 * To fulfill such requirements, a new grammar, similar to the already existing 
 * ones, should be added to the CleanSheets aplication.
 * <br/>
 * <br/>
 * <b>Use Case "Macros Window":</b>
 * The user opens the macros window. From here on out he can either create a new
 * macro, select a pre-existing one, or cancel the macro creating process
 * altogether. Although there is an option to select an existing macro, it is not
 * the purpose of this use case to implement a persistance mechanism that saves
 * created macros between sessions, thus it will only be possible to load macros
 * created in the same CleanSheets session. Prior to creating a macro there are 
 * several options that a user should contemplate. These are, respectively,
 * selecting and adding a function from a list of available CleanSheets
 * functions, adding an operator or writing a comment. Although the previous
 * process is somewhat limited in terms of possibilities, since those options
 * are almost entirely hidden from the user interface, it is possible to
 * customize macros at any given time by pressing an editing button that 
 * will allow the user to make all the changes he may find appropriate.
 * <br/>
 * <br/> 
 * <h2>2. Analysis</h2>
 * In order to implement macro creation it is primarily necessary to understand
 * how functions, formulas and grammars have been implemented inside the
 * CleanSheets application. Since macros creation consists, at least during this
 * stage, only in a sequence of formulas that will be executed by order, it is a
 * good idea to have a list of all implemented formulas so that the user can
 * choose them from a known formula list. Before that, however, it is
 * fundamental to have the right notion of what a formula is inside the 
 * CleanSheets paradigm. Is a formula the same thing as a function? Or does it
 * englobe operators or something else? 
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
 * Through this early draft we can see that the class SearchWorkbookFiles will
 * have total responsibilities in regards to the workbook files search. The user
 * interface will have to communicate through a controller in order to gain
 * access to all the functionalities provided by the SearchWorkbooksFilesClass.
 * <br/>
 * <br/> 
 * <h3>Analysis of The Core Technical Problem</h3>
 * The core technical problem for this use case will be understanding how to run
 * macros, correctly defining the too embracing formula concept to a more narrow
 * and objective definition and understanding how grammars are stored and
 * compiled inside the CleanSheets application.
 * <br/>
 */

package csheets.userstories.macros06_01.macros_window.i130385;

/**
 *
 * @author João Paiva (1130385)
 */
class _Dummy_ {}


