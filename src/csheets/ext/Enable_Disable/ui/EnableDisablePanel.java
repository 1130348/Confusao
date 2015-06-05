/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Enable_Disable.ui;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ext.comments.CommentsExtension;
import csheets.ui.MenuBar;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.SideBarAction;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Marcos
 */
@SuppressWarnings("serial")
public class EnableDisablePanel extends JPanel {

	/**
	 * The assertion controller
	 */
	private static JPanel jp;
	private EnableDisableController controller;
	/**
	 * The text field in which the comment of the cell is displayed.
	 */
	private JTextArea commentField = new JTextArea();

	public EnableDisablePanel(UIController uiController) {
		super(new BorderLayout());
		setName(CommentsExtension.NAME);
//		System.out.println(uiController.getExtensions().length);
		// Creates controller

		controller = new EnableDisableController(uiController, this);

		//uiController.addSelectionListener(this);
		// Creates comment components
		EnableDisablePanel.ApplyAction applyAction = new EnableDisablePanel.ApplyAction();
		commentField.setPreferredSize(new Dimension(120, 240));		// width, height
		commentField.
			setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
		commentField.addFocusListener(applyAction);
		commentField.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Lays out comment components
		JPanel commentPanel = new JPanel();
		commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.PAGE_AXIS));
		JScrollPane p = new JScrollPane(commentPanel);

		CreateCheck(commentPanel);
		p.setSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		p.setPreferredSize(new Dimension(130, 336));

		//commentPanel.add();
		// Adds borders
		TitledBorder border = BorderFactory.createTitledBorder("EnableDisable");
		border.setTitleJustification(TitledBorder.CENTER);
		commentPanel.setBorder(border);

		// Adds panels
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(p, BorderLayout.NORTH);
		add(northPanel, BorderLayout.NORTH);
	}

	protected class ApplyAction implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
		}
	}

	private static void CreateCheck(JPanel p) {
		for (final Extension ext : ExtensionManager.getInstance().
			getExtensions()) {

			// falta retirar enable disable
			final JCheckBox check = new JCheckBox(ext.getName());
			final String name = ext.getName();
			check.setSelected(ext.Status());
			p.add(check);
			jp = p;
			check.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (check.isSelected()) {
						ext.defineStatus(true);
						MenuBar.run();
						SideBarAction.fix(ext);
					}
					if (!check.isSelected()) {
						ext.defineStatus(false);
						MenuBar.run();
						SideBarAction.fix(ext);
					}
				}
			});
			if (ext.getName().equalsIgnoreCase("Enable/disable")) {
				check.setEnabled(false);
			}
		}
	}
}
