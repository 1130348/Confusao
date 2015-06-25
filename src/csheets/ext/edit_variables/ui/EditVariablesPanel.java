/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Variable;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.Reference;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Language;
import csheets.ext.edit_variables.EditVariablesController;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesPanel extends JPanel{
    
    private final UIController uiController;
    private final EditVariablesController controller;
    private SortedSet<Variable> listVariabels = new TreeSet<>();
    private JComboBox jcombobox = new JComboBox();
    private JList jlistAddress = new JList();
    private JTextField jtf1;
    private JTextField jtf2;

    EditVariablesPanel(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;
        this.controller = new EditVariablesController(uiController, this);
        initComponents();
    }

    private void initComponents() {
        
        JPanel north = new JPanel();
        
        north.add(new JLabel(" Variables:"),BorderLayout.WEST);
        
        ItemListener itemListener = new ItemListener() {
        public void itemStateChanged(ItemEvent itemEvent) {
          Object item = itemEvent.getItem();

          if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
              jlistAddress.removeAll();
                  Variable v = (Variable)jcombobox.getSelectedItem();
                  List<Address> listTmp = controller.getAddressVariable(v.getName());
                  jtf2.setText(v.getValue().toString());


                  jlistAddress.setListData(listTmp.toArray());
                  jlistAddress.setEnabled(true);
          }
        }
        };
        
        jcombobox.addItemListener(itemListener);
        jcombobox.setPrototypeDisplayValue("                                                         ");
        
        north.add(jcombobox,BorderLayout.EAST);
        
        add(north,BorderLayout.NORTH);
        
        JPanel center = new JPanel();
        
        center.add(new JLabel(" Value:   "),BorderLayout.WEST);
        jtf2 = new JTextField();
        jtf2.setText("            ");
        center.add(jtf2,BorderLayout.CENTER);
        JButton jb1 = new JButton("Change Value");
        center.add(jb1,BorderLayout.EAST);
        
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Variable v = (Variable)jcombobox.getSelectedItem();
                v.setValue(new Value(jtf2.getText()));
            }
        });
        
        add(center,BorderLayout.CENTER);
        
        JPanel jpanel = new JPanel();
        JLabel label = new JLabel("List of address where the cell is used:");
        List tmp = new ArrayList<Object>();
        tmp.add("Vazio");
        jlistAddress.setListData(tmp.toArray());
        jpanel.add(label,BorderLayout.NORTH);
        jpanel.add(jlistAddress,BorderLayout.CENTER);
        add(jpanel,BorderLayout.SOUTH);
      
    }
    
    public void update(){
        try {
            listVariabels = uiController.getActiveWorkbook().getVariables();
        } catch (Exception e) {
        }
        
        jcombobox.removeAllItems();
        for (Variable var : listVariabels) {
            jcombobox.addItem(var);
        }
        
        if(jcombobox.getItemCount()!=0)
        {
            jcombobox.setSelectedIndex(0);
            jtf2.setEnabled(true);
        }
        
    }
    
    
    /**
	 * Will call the class Listener that will implement cell listeners. If the
	 * content of cells were changed the variable ModicationOnCells of
	 * uiController will be setted to true and then the thread will export the
	 * cells to the file.
	 */
	public void modifications() {
		controller.modifications();
	}
}
