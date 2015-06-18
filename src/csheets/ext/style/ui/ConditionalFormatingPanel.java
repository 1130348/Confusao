/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose
 */
public class ConditionalFormatingPanel extends JPanel {

	public static JLabel adress = new JLabel("Cell address", 10);
	;

	private UIController uiController;

	public ConditionalFormatingPanel(UIController uiController) {
		super(new BorderLayout());
		this.uiController = uiController;
		initComponents();
	}

	private void initComponents() {
		JPanel pane1 = new JPanel();
		String[] operator = new String[]{">", "<", "="};
		String[] colors = new String[]{"Red", "Green", "Blue", "Black"};
		JPanel conditionPanel = new JPanel();
		JPanel paneltrue = new JPanel();
		JPanel panelfalse = new JPanel();
		JPanel colorsPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JComboBox box1 = new JComboBox();
		JButton button1 = new JButton("Apply");
		JTextField in = new JTextField("Value...", 10);
		box1.setModel(new DefaultComboBoxModel(operator));
		JLabel truecolor = new JLabel();
		truecolor.setText("Color for case True");
		JLabel falsecolor = new JLabel();
		falsecolor.setText("Color for case False");
		JComboBox boxColorTrue = new JComboBox();
		boxColorTrue.setModel(new DefaultComboBoxModel(colors));
		JComboBox boxColorFalse = new JComboBox();
		boxColorFalse.setModel(new DefaultComboBoxModel(colors));
		paneltrue.add(truecolor);
		paneltrue.add(boxColorTrue);
		panelfalse.add(falsecolor);
		panelfalse.add(boxColorFalse);
		conditionPanel.add(box1);
		conditionPanel.add(in);
		colorsPanel.add(paneltrue, BorderLayout.NORTH);
		colorsPanel.add(panelfalse, BorderLayout.CENTER);
		centerPanel.add(conditionPanel, BorderLayout.NORTH);
		centerPanel.add(colorsPanel, BorderLayout.CENTER);
		add(adress, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(button1, BorderLayout.SOUTH);
	}

}
