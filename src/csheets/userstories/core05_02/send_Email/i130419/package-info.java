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
 * functionality of this use case is to send email. The most appropriate test
 * type for this use case is the functional type. To test the correct sending
 * email we will send test emails and verify that these emails will be received.
 * In addition to the functional tests will be some functional testing to verify
 * that the information is being properly allocated will MimoMessag class.
 * <br/>
 * <br/>
 * see: <code>csheets.userstories.core05_02.send_email.SendEmailTest</code><br/>
 *
 * <h2>4. Design</h2>
 * When user enter the cell content he/she activate the method actionPerformed
 * of Class CellEditor. This User Story uses mostly intefaces and has the
 * particularity of having 2 classes that are automatically generated by the
 * respective intefaces, those classes are FormulaLexer and FormulaParser and
 * there are specific Java classes (Lexer and Parser) that generated depending
 * on the grammar created.<br/>
 * For the development of the base operator we dont have to define it in the
 * grammar because we did it in the previous use case so now we just have to
 * implement the behavior of said rule in the respective class.<br/>
 * The class ExpressionCompiler during runtime will identify and decide what
 * type of command is written and choose the correct behavior.<br/>
 * The interface Function will decide wich function will apply, in this use case
 * will use the class Minverse and Mmult. The following diagram illustrate the
 * approach used in the design of the solution for this use case.<br/>
 * <img src="doc-files/sequence_diagram.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <br/>
 *
 * <h2>6. Final Remarks</h2>
 * We achieve the objectives and in our point of view all requirements have been
 * accomplished. In addition we can do extra work implementing some features of
 * macros 03 03.<br/>
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
