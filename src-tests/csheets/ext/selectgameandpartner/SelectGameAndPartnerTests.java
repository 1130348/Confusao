/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgameandpartner;

import csheets.ext.selectgame.Player;
import csheets.ext.selectgame.SelectGameController;
import csheets.ext.selectgame.ui.ChoosePartner;
import csheets.ext.selectgame.ui.GameScene;
import java.net.InetAddress;
import java.util.Map;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sergio
 */
public class SelectGameAndPartnerTests {

	public SelectGameAndPartnerTests() {
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
	 * Test of establishConnection method, of class SelectGameController.
	 */
	@Test
	public void testEstablishConnection() {
		System.out.println("establishConnection");
		String playerName = "";
		SelectGameController instance = new SelectGameController();
		instance.establishConnection(playerName);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of sendUserInfo method, of class SelectGameController.
	 */
	@Test
	public void testSendUserInfo() {
		System.out.println("sendUserInfo");
		Player player = new Player();
		player.setName("Sergio");
		player.setPlayerIcon(new ImageIcon("icons/icon1"));
		SelectGameController instance = new SelectGameController();
		instance.sendUserInfo(player);
		GameScene dialog = new GameScene(null, true, instance, "Chekers");
		Player result = dialog.getPlayerData();
		assertEquals(player, result);
	}

	/**
	 * Test of setActiveGame method, of class SelectGameController.
	 */
	@Test
	public void testSetActiveGame() {
		System.out.println("setActiveGame");
		String game = "Checkers";
		SelectGameController instance = new SelectGameController();
		instance.setActiveGame(game);
		assertEquals(game, "Checkers");
	}

	/**
	 * Test of removeActiveGame method, of class SelectGameController.
	 */
	@Test
	public void testRemoveActiveGame() {
		System.out.println("removeActiveGame");
		String game = "";
		SelectGameController instance = new SelectGameController();
		instance.removeActiveGame(game);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setVisibility method, of class SelectGameController.
	 */
	@Test
	public void testSetVisibility() {
		System.out.println("setVisibility");
		boolean b = false;
		SelectGameController instance = new SelectGameController();
		instance.setVisibility(b);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of searchInstances method, of class SelectGameController.
	 */
	@Test
	public void testSearchInstances() {
		System.out.println("searchInstances");
		SelectGameController instance = new SelectGameController();
		Map<InetAddress, Integer> expResult = null;
		Map<InetAddress, Integer> result = instance.searchInstances();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of startGameServer method, of class SelectGameController.
	 */
	@Test
	public void testStartGameServer() {
		System.out.println("startGameServer");
		GameScene dialog = null;
		Player player = null;
		ChoosePartner partnersDialog = null;
		SelectGameController instance = new SelectGameController();
		instance.startGameServer(dialog, player, partnersDialog);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of interruptConnection method, of class SelectGameController.
	 */
	@Test
	public void testInterruptConnection() {
		System.out.println("interruptConnection");
		SelectGameController instance = new SelectGameController();
		instance.interruptConnection();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
