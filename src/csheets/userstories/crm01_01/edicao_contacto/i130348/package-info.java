/**
 * Technical documentation regarding the user story crm01_01: contact edition.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Side window that allows creating, editing and removing one contact. The
 * contact has got first and last name and a photo/image associated. Contacts
 * also have a agenda with events (that may appear in a different sidebar). One
 * of the contacts can be the user with an active session on the computer. For
 * the cleansheets user when it reaches the date of an event it should appear a
 * window that notifies. An event has just a "timestamp" of its occurence and
 * descriptive text.
 * <br/>
 * <br/>
 * <b>Use Case "Contact Edition":</b> First of all to enter the CRM Area the
 * user needs to login or register. When the The user selects one of the option:
 * Agenda or Contact. After that if the choosen option is Contact that will have
 * more three option: Create, Edit and Remove a contact. If the user choose
 * option create it will appear a window for the user to enter his first and
 * last name and to select an image or a photo for the contact. On the
 * otherhand, if the choosen option is edit the user has the possibility to
 * change all the information associated with the contact. Otherwise if the user
 * opted for the removing option it will appear all contacts that the user can
 * remove in order to select. If the user wants to edit the agenda there is a
 * sidebar for that effect and the user needs to choose the option: Agenda.
 * After that the user can choose if wants to create an event, edit ou remove
 * for the agenda. If the option is Create the system will ask for all the
 * information and validates and ask the user for confirmation. On the other
 * side, if the choosen option is Edit or Remove the system show all the events
 * for the user to select one. The system will allow the user to edit or to
 * remove one. The system informs the sucess of the use case.<br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * Since editing a contact will be supported in a database that will be included
 * in the cleansheet projet will need to study how to make the connection.<br/>
 * The first sequence diagram in the section
 * <a href="POR AQUI">Application Startup</a> tell us about some of the classes
 * that will need to create in order to conclude this use case like Contact and
 * Event.<br/>
 * The DataBase will need to save all the information about a contact: the list
 * of contacts, personal informations and the agenda with all of the
 * events.<br/>
 * The possibily from right now is to create one side bar with two options:
 * Contact and Agenda. <br/>
 * CONTACT: Create, Edit or Remove <br/>
 * AGENDA: Create, Edit or Remove an Event <br/>
 * <br/>
 * Below it's a prototype for the summary of a SSD if the user choose the option
 * Contact and then Create.<br/><br/>
 * <img src="doc-files/comments_uc_ssd1_crm_01_01.png">
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram of the Contact Creation</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created). <br/>
 * Let's now see the sequence diagram. This is just a summary of a proposal.
 * This analyse diagram will probably be changed in the Design part after
 * thinking and analyzed all the project and will updates to a sequence diagram.
 * <br/>
 * <br/>
 * <img src="doc-files/comments_extension_uc_analysis_crm_01_01.png">
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to create a class Contact with
 * 3 attributes: first_name, last_name and associated_image. It is also
 * necessary to create a class Event and Agenda. An event has two attributes:
 * timestamp and a descriptive_text.  <br/>
 * Therefore, at this point, we need to study how to create, edit and remove a
 * contact and his agenda (create, edit and remove an event). It's very
 * important too the form that will be create the connection with the database
 * and how will be integrated in cleansheets projet. One more study target is
 * the notification to the user when the date of an event aproaches.<br/>
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the crm
 * functionality of this use case is to be able to edit a contact, edit a agenda
 * and to notify about the next events. There are a lot of tests that will need
 * to be done about the connection of the database, the contact class, the
 * agenda class and the event class. After that also controller will need tests
 * in order to validate all the implemented methods. <br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>CLASSE DE TESTES</code><br/>
 *
 * <h2>4. Design</h2>
 * This part of the documentation of this use case (CRM: Contact Edition)has 3
 * parts: <br/>
 * - Sequence Diagram </br>
 * - Class Diagram </br>
 * - Explanation about some classes <br/>
 *
 * <h5>4.1. Sequence Diagram </h5>
 * A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenaria and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * The sequence diagram had to be dividided into several parts because it is an
 * extensive sequence diagram. <br/>
 *
 * <br/>POR AQUI OS DIAGRAMAS DE SEQUÊNCIA DIVIDIDOS<br/>
 * <br/>
 *
 * <h5>4.2. Class Diagram </h5>
 * A class diagram is a representation of the structure and the relationships
 * between all the classes that serve as model for objets. It is very useful for
 * the development of modeling systems because defines all the classes the
 * system needs to possess and is the basis for the construction of
 * communication diagrams and sequence.<br/>
 * <br/>POR AQUI O DIAGRAMA DE CLASSES<br/>
 * <br/>
 *
 * <h5>4.3. Explanation about some classes</h5>
 *
 * <br/>
 *
 * <h2>5. Coding</h2>
 * <br/>
 *
 * <h2>6. Final Remarks</h2>
 * This use case is the first of a series which will require connection with the
 * database and some integration with cleansheets. All of the use case from
 * Customer Relationship Management (CRM) area will need this connection to the
 * database in order to save information. It can be treated like a complex use
 * case because there are lots of aspects that will need to be done like
 * connection with the database, register and login, create, edit and remove a
 * contact or an event and notify the user that is login about the next
 * events.<br/>
 * <br/>
 * <br/>
 *
 */
package csheets.userstories.crm01_01.edicao_contacto.i130348;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Egidio Santos
 */
class _Dummy_ {
}
