package csheets.ext.comments;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import junit.framework.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * A Unit Test class to test Tooltips.
 * 
 * @author 1130395
 */
public class TooltipsTest {
	
	private boolean isNotified=false;

	/**
	 * A method that tests the property user.
	 */
	@Test public void testHasUser() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		CommentableCell cc=new CommentableCell(c);

		boolean hasComment=cc.hasComment();
		
			
		
		cc.setUserComment("coment");
                cc.setUser(System.getProperty("user.name"));
                String user = cc.getUser();

                String temp = System.getProperty("user.name");
		
                Assert.assertEquals(user, temp);
                
	}

	/**
	 * A method that tests multiple comments
	 */
	@Test public void testSetGetUserComment() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		CommentableCell cc=new CommentableCell(c);

		cc.setUserComment("Hello");
                cc.setUserComment("Hello");
		
		Assert.assertEquals(cc.getSingleUserComment(0), cc.getSingleUserComment(1));
	}
	
	/**
	 * A method that tests the tooltips.
	 * @see CommentableCellListener
	 */	
	@Test public void testTooltips() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		CommentableCell cc=new CommentableCell(c);
		
		CommentableCellListener listener=new CommentableCellListenerImpl();
		
		cc.addCommentableCellListener(listener);

		// modify the cell... this should create an event
		cc.setUserComment("Hello");
		
		assertTrue(isNotified);		
	}

	/**
	 * A inner utility class used by the method testCommentableCellListenner.
	 */	
	class CommentableCellListenerImpl implements CommentableCellListener {

		@Override
		public void commentChanged(CommentableCell cell) {
			isNotified=true;
		}
		
	}
}
