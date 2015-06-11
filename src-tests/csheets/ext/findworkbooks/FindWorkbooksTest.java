/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksTest {
    
    public FindWorkbooksTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of visitFile method, of class FindWorkbooks.
     */
    @Test
    public void testVisitFile() throws Exception {
        System.out.println("visitFile");
        Path path = null;
        BasicFileAttributes attrs = null;
        FindWorkbooks instance = null;
        FileVisitResult expResult = null;
        FileVisitResult result = instance.visitFile(path, attrs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postVisitDirectory method, of class FindWorkbooks.
     */
    @Test
    public void testPostVisitDirectory() throws Exception {
        System.out.println("postVisitDirectory");
        Path dir = null;
        IOException exc = null;
        FindWorkbooks instance = null;
        FileVisitResult expResult = null;
        FileVisitResult result = instance.postVisitDirectory(dir, exc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitFileFailed method, of class FindWorkbooks.
     */
    @Test
    public void testVisitFileFailed() throws Exception {
        System.out.println("visitFileFailed");
        Path file = null;
        IOException exc = null;
        FindWorkbooks instance = null;
        FileVisitResult expResult = null;
        FileVisitResult result = instance.visitFileFailed(file, exc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
