/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csheets.ext.call_function.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Andre
 */
public class FormulasPanel extends JPanel {

	public static JList formulas = new JList();
	public static List form;
        private static int cont;

	public FormulasPanel(UIController uicontroller) {
		super(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		form = new ArrayList<String>();
                cont = 0;

		scroll.setViewportView(formulas);
		add(scroll);
	}

	public static void addFormula(String formula) {
		form.add((++cont) + ". " + formula);
		formulas.setListData(form.toArray());
	}
}
