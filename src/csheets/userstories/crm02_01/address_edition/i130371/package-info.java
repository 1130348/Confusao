/**
 * Technical documentation regarding the user story crm02_01: address edition.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Side window that allows creating, editing and removing address of the
 * contact. One address has got the street, locality, postal code, city and
 * country. Each contact can have two address: the main one and a secondary. In
 * the case of Portugal addresses of the postal code should be validated. The
 * list of postalcodes should be in a text file.
 * <br/>
 * <br/>
 * <b>Use Case "Address Edition":</b>
 * First the user opens the sidebar "Address" in order to create, edit or remove
 * address. The user just need to choose one contact and select with two clicks.
 * A window will be open to the user insert all the information (street,
 * locality, postal code, city and country) and if it's the main or the
 * secundary address. If the user want's to delete one address just need to
 * select remove option. The system informs the sucess of the use case.<br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * Since editing a contact is supported in a database that will be included in
 * the cleansheet projet will need to study how the class address with be
 * integrated on the database too.<br/>
 * The first sequence diagram in the section Application Startup</a> tell us
 * about some of the classes that will need to create in order to conclude this
 * use case like Address and the Contact will have two more attributes (main
 * Address and the secondary Address).<br/>
 * The DataBase will need to save all the information about the two address
 * (main and secundary) of the contact.<br/>
 * The possibily from right now is to create one side bar called "Address".<br/>
 * ADDRESS: Selects one contact then happens a window to create, edit or remove
 * the address. <br/>
 * <br/>
 * Below it's a prototype for the summary of a SSD.
 * <br/><br/>
 * <img src="doc-files/crm_02_01_ssd.png">
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram of the Address Creation</h3>
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
 * <img src="doc-files/crm_02_01_analysis_sequence.png">
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to create a class Address with
 * 5 attributes: street, locality, postal code, city and country. It is also
 * necessary to add to the class Contact two more attributes: main_address and
 * secundary_main.<br/>
 * Therefore, at this point, we need to study how to create, edit, select and
 * remove an address. It's very important too the form that will be create the
 * connection with the database and how will be integrated in cleansheets
 * projet. One more study target is the validation of portuguese postal code
 * using a text file.<br/>
 * <br/>
 * From right now the ideia is to creat the class: AddressController ad Address.
 * Below there is the first prototype of the classes diagram of this projet
 * cleansheets. Besides all that classes already said there are a
 * ContactsRepository, a Factory called RepositoryFactory and the persistence
 * that allows the connection with the database.<br/> <br/>
 * <img src="doc-files/crm_02_01_analysis_classes.png">
 * <br/><br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the crm
 * functionality of this use case is to be able to edit the main and the
 * secundary address. There are a lot of tests that will need to be done about
 * the connection of the database, the contact class, the address class. After
 * that also controller will need tests in order to validate all the implemented
 * methods. <br/>
 * The test classes "ContactControllerTest" and "ContactTest" already exist
 * because of the use case "CRM01_01 Contact Edition" but were updated to fill
 * all the requirements of this use case. Just the class "Address Test" was
 * created now and has test like gets and sets to all the attributes of an
 * Address.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.crm.ContactControllerTest</code><br/>
 * see: <code>csheets.crm.ContactTest</code><br/>
 * see: <code>csheets.crm.AddressTest</code><br/>
 *
 * <h2>4. Design</h2>
 ** A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenario and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * A new sidebar will be created in order to the use add, edit or remove the two
 * address of a contact. On that sidebar the user selects with two clicks one
 * contact and a window will be open in order to write or edit the address. Then
 * the user just need to save and the contact will be updated.
 *
 * <h2>5. Coding</h2>
 *
 * <h2>6. Final Remarks</h2>
 * This use case is the first of a series which will require connection with the
 * database and some integration with cleansheets. All of the use case from
 * Customer Relationship Management (CRM) area will need this connection to the
 * database in order to save information. The contact has got all the attributes
 * and now two address: the main and the secundary. The information of all the
 * address needs to be save on the database<br/>
 * <br/>
 * <br/>
 *
 */
package csheets.userstories.crm02_01.address_edition.i130371;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Cristina Lopes
 */
class _Dummy_ {
}
