/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.crm;

import csheets.ext.contact.Note;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio Pinheiro
 */
public class NoteTest {

    @Test
    public void testSetGetTitle()
    {
        Note note = new Note();
        
        String title = "title";
        
        note.setTitle(title);
        String expResult = title;
        String result = note.getTitle();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetGetText()
    {
        Note note = new Note();
        
        String text = "text";
        
        note.setText(text);
        String expResult = text;
        String result = note.getText();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetGetTimestamp()
    {
        Note note = new Note();
        
        Date d = new Date();
        
        note.setTimestamp(d);
        Date expResult = d;
        Date result = note.getTimestamp();
        
        assertEquals(expResult, result);
    }
    
    
}
