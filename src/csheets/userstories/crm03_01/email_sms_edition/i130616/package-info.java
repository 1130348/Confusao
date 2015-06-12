/**
 * Technical documentation regarding the user story crm03_01: email's and sms edition.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Window that allows for creating, editing and removing emails and phone a contact. 
 * It should only be possible to register e-mail and correct syntactically phones. 
 * For emails must be a principal and several secondary. 
 * For phones should be: fixed work, fixed home, mobile work, personal mobile. 
 * The application should validate the indicative phones according to the country code.
 * <br/>
 * <br/>
 * <b>Use Case "Email and SMS edition":</b>
 * The user selects one contact and the edit option and he has the possibility to
 * change all the information associated with the contact. 
 * In this case, the user is allowed to create, edit or remove emails and/or phone numbers.
 * <br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * <br/> This use case is the continuation of the crm01_01 (contact edition), 
 * so all the changes of information will be save in database.
 * <br/> It will use the same GUI and classes. 
 * It will be necessary add 4 atributes (all the 4 types of phone numbers) and a list with the emails (primary will be in first position of the list) to the Contact class.
 * For the phone numbers it will be create a class PhoneNumber with the respective validate method, and for Emails the same.
 * Add/edit/delete phone numbers will work the same way. If user wants to delete, delete the text in the field. If wants to add or edit, replace the text.
 * For emails in the frame with contact info, will see a list of emails. The first is the primary.
 * 
 * <img src="doc-files/contact_extension_uc_analysis_crm_03_01.png">
 * <br/>
 * The requirements said that Contact have 4 types of PhoneNumbers, so it will be necessary add 4 atributtes.
 * About emails, it said that the contact have atleast 1 email, and no limit, so Contact class need to have a list of emails.
 * To not overload the Contact class with methods that correspond to e-mail and phone number,
 * will be created two classes, one for each type of data which will include their syntax validation.
 * 
 * <img src="doc-files/contact_extension_uc_classes_analysis_crm_03_01.png">
 * <h3>Analysis of Core Technical Problem</h3>
 * As the contact is in the persistence, the problem is add more atributes to database and manage them.
 *
 * 
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, the emails and phone numbers need to be validate.
 * Following this approach we can start by coding a unit test to validate them.
 * Emails and phonenumbers need to be in database, so we need to check if persistence is saving the information.
 * see: <code>csheets.ext.contact.EmailTest</code><br/>
 * <code>csheets.ext.contact.PhoneNumberTest</code><br/>
 * 
 * <h2>4. Design</h2>
 *<img src="doc-files/crm_03_01_email_sequence_diagram_design.png">
 * <img src="doc-files/crm_03_01_phonenumber_sequence_diagram_design.png">
 * 
 * <h2>5. Coding</h2>
 * see: <code>csheets.ext.contact.Email</code><br/>
 * <code>csheets.ext.contact.PhoneNumber</code><br/>
 * <code>csheets.ext.contact.ContactController</code><br/>
 * <code>csheets.ext.contact.Contact</code><br/>
 *
 * <h2>6. Final Remarks</h2>
 * 
 * 
 * 
 * <br/>
 * <br/>
 * 
 * @author rddm
 * 
 */
package csheets.userstories.crm03_01.email_sms_edition.i130616;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Ricardo Moreira
 */
class _Dummy_ {
}
