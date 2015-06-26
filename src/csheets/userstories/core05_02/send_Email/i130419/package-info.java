/**
 * Technical documentation regarding the user story core05.02: Send Email
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Add a window that allows you to send an email. It should be possible to
 * indicate e-mail receivers, the subject and the message. It should be possible
 * to include in the message body the contents of an area of the sheet. In the
 * sidebar window should now display the history of all sent messages. By
 * clicking on one of these historic messages should appear in your detail
 * window similar to the send window.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Advanced Functions":</b>
 * The user selects the option to send email. The system displays a window with
 * the receiver, subject and message field. The user enters one or more
 * receiver, the subject and the message. The user may optionally send a content
 * area of ​​the sheet. The system notifies that the mail was sent successfully.
 * The user selects a message from historic of email. The system displays a
 * window with information relating to this email.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To solve this use case will be necessary to understand how to send emails
 * with Java.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/draft_send_email.png">
 * <br/>
 * <br/>
 * From the previous diagram we see that we need a class to send the email.<br/>
 * Therefore, at this point, we need to study how to send the email. This is the
 * core technical problem regarding this issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * After reviewing the documentation and the code made ​​by the student 1120835
 * in the use case core05_01 it was determined that we would send email through
 * an external library (javax.mail). After reading the javax.mail API we can see
 * that the MimeMessage class from javax.mail library can replace the Email
 * class represented in the analysis draft. This class has method to set one or
 * more receivers, subject and message. To send an email the library also
 * provides us with a service class called Transport that sends a MimeMessage
 * object followed by the email and password of the sender.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to send emails. The most appropriate test
 * type for this use case is the functional type. To test the correct email
 * sending we will send emails tests and verify that these emails will be
 * received. In addition to the functional tests will be some unitary testing to
 * verify that the information is being properly allocated in MimoMessage class.
 * <br/>
 * <br/>
 * see: <code>csheets.ext.sendEmail.SendEmailTest</code><br/>
 *
 * <h2>4. Design</h2>
 *
 * <h3>Sending Email</h3>
 * When the user selects the option to send e-mail, the program will prepare a
 * session for sending an email. This session will receive the data for the mail
 * sending protocol and the user's server. After the session is set up it
 * creates a MimoMessage to put the information that will be sent to the desired
 * email.<br/>
 * <img src="doc-files/sequence_diagram.png"/>
 * </br>
 * <h3>Open outbox</h3>
 * When the user selects one of the email in the output box the system presents
 * to the user a window with information for the selected email. The user can
 * edit the email and re-submit.
 * <br/>
 * <img src="doc-files/open_outbox_sequence_diagram.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.ext.sendEmail</a>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.ext.sendEmail.UI</a><br/>
 * <br/>
 * <br/>
 *
 * <h2>6. Final Remarks</h2>
 * We achieve the objectives and in our point of view all requirements have been
 * accomplished. The design of the solution didn't turn out not to be the best
 * because it was necessary to implement parts of the use case core05.01 and
 * that put me slightly out of schedule.<br/>
 *
 * @author 1130419
 */
package csheets.userstories.core05_02.send_Email.i130419;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 *
 * @author Paulo Pereira
 */
class _Dummy_ {
}
