/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author DMMCA
 */
public class ExtensionTest {

	/**
	 * Test of Status method, of class Extension.
	 */
	@Test
	public void testStatus() {
		System.out.println("Status");
		Extension instance = new Extension("TestExtension") {
		};
		boolean expResult = true;
		boolean result = instance.Status();
		assertEquals(expResult, true);
	}
}
