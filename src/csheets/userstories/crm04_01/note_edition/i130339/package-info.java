/**
 * Technical documentation regarding the user story crm04_01: note edition.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * It should be possible to create , edit and remove notes associated with contacts. A
 * note consists of free text in which the first line is used to set the title . 
 * The creation timestamp should be associated to the note. A history of changes to the notes should be kept . 
 * When someone selects a note it should appear a list of all its versions . For each version it should appear
 * timestamp and the first line . The issue is always on the latest version . However, it should be possible to
 * select a previous version for editing. In this case the text of the selected version is automatically
 * placed as text of the new version of editing.
 * <br/>
 * <br/>
 * <b>Use Case "Note Edition":</b>
 * When the user opens the Edit Contact Window, it's given the option to add, edit or remove a note
 * from the contact. If he chooses to create a new note, a new window will apear where he can introduce
 * the text associated to the note. If the option is Edit, he will see all the previous versions of
 * the note, and if he wants to edit one of them. If he decides to remove one note, the user only have
 * to select the note and press Remove.<br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * In order to add notes to a contact, it will be necessary to create two important classes: Notes and Note.
 * The first one is a attribute of Contact, where all the versions of notes associated with the contact will be stored,
 * for this to happen the class has a list of Note. The Note is the most important class of this usecase 
 * and will have 3 attributes: <br>Title, to represent what the note is about;</br> <br>Text, the description of the note;</br> <br>Timestamp, represents the time of creation;</br>
 * Since editing a contact is supported in a database that will be included in
 * the cleansheet projet, it will be necessary to investigate how the notes will be added to
 * the contact on the database.<br/>
 * <br/>
 * Below it's a prototype for the summary of a SSD.
 * <br/><br/>
 *  FALTA SSD
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram of the Note Edition</h3>
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
 * <img src="doc-files/crm_04_01_sequence_diagram_analysis.png">
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to create a class Notes, an attribute of
 * contact, that will have a list of notes, for that it will be necessary to create the class Note
 * that will have as attributes, the timestamp, the title and the respective text.<br/>
 * Therefore, at this point, we need to study how to create, edit and remove a note, and the changes
 * that will be necessary in the database to support the notes<br/>
 * <br/>
 * 
 * <img src="doc-files/crm_04_01_class_diagram.png">
 * <br/><br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * The core technical problem is to see how both classes Notes and Note will interact with Contact
 * on the DataBase.
 * <br/>
 * <h2>3. Tests</h2>
 * see: <code>csheets.crm.ContactControllerTest</code><br/>
 * see: <code>csheets.crm.ContactTest</code><br/>
 * see: <code>csheets.crm.NoteTest</code><br/>
 * see: <code>csheets.crm.NotesTest</code><br/>
 * <h2>4. Design</h2>
 * <br/>
 * A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenario and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * 
 * <img src="doc-files/crm_04_01_sequence_diagram_design.png">
 * <br/><br/>
 * <h2>5. Coding</h2>
 * see: <code>csheets.ext.contact.Contact</code><br/>
 * see: <code>csheets.ext.contact.Note</code><br/>
 * see: <code>csheets.ext.contact.Notes</code><br/>
 * see: <code>csheets.ext.contact.ui.ContactController</code><br/>
 * see: <code>csheets.ext.contact.ui.EditContact</code><br/>
 * see: <code>csheets.ext.contact.ui.EditNote</code><br/>
 * <h2>6. Final Remarks</h2>
 * 
 * <br/>
 * <br/>
 *
 */


package csheets.userstories.crm04_01.note_edition.i130339;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Antonio Pinheiro
 */
class _Dummy_ {
}



