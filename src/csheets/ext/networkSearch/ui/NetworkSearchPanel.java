/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkSearch.ui;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis
 */
public class NetworkSearchPanel extends JPanel {

	public static JList foundWorkbooksList = new JList();

	private UIController uiController;

	public NetworkSearchPanel(UIController uiController) {
		super(new BorderLayout());
		this.uiController = uiController;
		initComponents();
		openFoundWorkbook();
	}

	private void initComponents() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(foundWorkbooksList);
		add(scrollPane);
	}

	private void openFoundWorkbook() {
		if (foundWorkbooksList != null) {
			foundWorkbooksList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						Workbook book = new Workbook();
						CleanSheets app = uiController.getApp();
						File file = new File(foundWorkbooksList.
							getSelectedValue().toString());
						if (file.exists()) {
							Workbook workbook = app.getWorkbook(file);
							uiController.setActiveWorkbook(workbook);

							if (workbook == null) {
								try {
									app.load(file);
								} catch (IOException | ClassNotFoundException ex) {
									System.out.println("Exception: " + ex);
									JOptionPane.showMessageDialog(null, ex);
								}
							} else {
								uiController.setActiveWorkbook(workbook);
							}
						}
					}
				}
			});
		}
	}
}
