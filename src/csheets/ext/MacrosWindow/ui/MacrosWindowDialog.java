/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.MacrosWindow.ui;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.ext.call_function.CallFunctionController;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.UnknownElementException;
import csheets.ext.MacrosWindow.MacrosWindowController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class MacrosWindowDialog extends javax.swing.JDialog {

    private static MacrosWindowDialog instance;
    private final MacrosWindowController macrosWindowController;
    private final CallFunctionController callFunctionController;
    private Function[] functions;
    private String macro;
    private final ArrayList<String> macroFormulasList;
    private final ArrayList<String> savedMacros;
    private final ArrayList<String> savedMacrosNames;

    /**
     * Creates new form MacrosWindowDialog
     *
     * @param parent
     * @param modal
     */
    private MacrosWindowDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        callFunctionController = new CallFunctionController();
        macrosWindowController = new MacrosWindowController();
        macroFormulasList = new ArrayList<String>();
        savedMacros = new ArrayList<String>();
        savedMacrosNames = new ArrayList<String>();
        initComponents();
        setDefaultComponentsSettings();
        retrieveFunctionsList();
        exitWindow();
    }

    private void exitWindow() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                clearMacroNameActionPerformed(null);
                dispose();
            }
        });
    }

    public static synchronized MacrosWindowDialog getInstance(java.awt.Frame parent, boolean modal) {
        if (instance == null) {
            instance = new MacrosWindowDialog(parent, modal);
        }
        return instance;
    }

    private void setDefaultComponentsSettings() {
        macro = "";
        currentMacroTextArea.setText("");
        availableMacrosComboBox.addItem("There are no saved macros");
        availableMacrosComboBox.setEnabled(false);
        loadMacroButton.setEnabled(false);
    }

    private void retrieveFunctionsList() {
        functions = macrosWindowController.retrieveFunctionsList();
        for (int i = 0; i < functions.length; i++) {
            formulaComboBox.addItem(functions[i].getIdentifier());
        }
    }

    private void calculateOperation() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        addFormulaButton = new javax.swing.JButton();
        formulaComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentMacroTextArea = new javax.swing.JTextArea();
        runMacroButton = new javax.swing.JButton();
        currentMacroPanel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        macroOutputTextField = new javax.swing.JTextField();
        availableMacrosComboBox = new javax.swing.JComboBox();
        loadMacroButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        saveMacroButton = new javax.swing.JButton();
        availableMacrosPanel = new javax.swing.JLabel();
        clearMacroName = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Macro");

        addFormulaButton.setText("Add Function");
        addFormulaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFormulaButtonActionPerformed(evt);
            }
        });

        currentMacroTextArea.setColumns(20);
        currentMacroTextArea.setRows(5);
        jScrollPane1.setViewportView(currentMacroTextArea);

        runMacroButton.setText("Run Macro");
        runMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMacroButtonActionPerformed(evt);
            }
        });

        currentMacroPanel.setText("Macro:");

        jLabel1.setText("Output:");

        loadMacroButton.setText("Load Macro");
        loadMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMacroButtonActionPerformed(evt);
            }
        });

        saveMacroButton.setText("Save Macro");
        saveMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMacroButtonActionPerformed(evt);
            }
        });

        availableMacrosPanel.setText("Saved Macros:");

        clearMacroName.setText("Clear Macro");
        clearMacroName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMacroNameActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addFormulaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(availableMacrosPanel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(availableMacrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loadMacroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(currentMacroPanel))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(macroOutputTextField))
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearMacroName, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(runMacroButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(saveMacroButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(availableMacrosPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableMacrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadMacroButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentMacroPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFormulaButton))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearMacroName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(runMacroButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveMacroButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(macroOutputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addFormulaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFormulaButtonActionPerformed
        macro = currentMacroTextArea.getText();
        if (!"".equals(macro)) {
            if (macro.charAt(macro.length() - 1) != '\n') {
                macro = macro.concat("\n");
            }
        }
        String formula = (String) formulaComboBox.getSelectedItem();
        try {
            macro += callFunctionController.chooseFunction(formula) + "\n";
        } catch (UnknownElementException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "This function has not yet been implemented!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        currentMacroTextArea.setText(macro);
    }//GEN-LAST:event_addFormulaButtonActionPerformed

    private void runMacroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMacroButtonActionPerformed
        boolean exception = false;
        if (!currentMacroTextArea.getText().isEmpty()) {
            Value value = new Value();
            String[] aux = currentMacroTextArea.getText().split("\n");
            macroFormulasList.addAll(Arrays.asList(aux));
            for (String formula : macroFormulasList) {
                try {
                    if (formula.charAt(0) != ';') {
                        if (formula.charAt(0) == '=') {
                            formula = formula.substring(1);
                        }
                        value = callFunctionController.callMacroFunction(formula);
                    }
                } catch (ParseException | IllegalFunctionCallException | UnknownElementException | IllegalValueTypeException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Some of the functions in the macro are not currently supported!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
                } catch (StringIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Your macro syntax is invalid!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
                }
            }
            macroFormulasList.clear();
            macroOutputTextField.setText(value.toString());
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "You have to add instructions to your macro before you can run it!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_runMacroButtonActionPerformed

    private void saveMacroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMacroButtonActionPerformed
        String MacroName = JOptionPane.showInputDialog(
                null,
                "Enter Macro name:",
                "Save Macro",
                JOptionPane.INFORMATION_MESSAGE
        );
        if (MacroName != null) {
            savedMacros.add(currentMacroTextArea.getText());
            availableMacrosComboBox.addItem(MacroName);
            availableMacrosComboBox.removeItem("There are no saved macros");
            availableMacrosComboBox.setEnabled(true);
            loadMacroButton.setEnabled(true);
        }
    }//GEN-LAST:event_saveMacroButtonActionPerformed

    private void loadMacroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMacroButtonActionPerformed
        int index = availableMacrosComboBox.getSelectedIndex();
        if (index != -1) {
            macro = savedMacros.get(index);
            currentMacroTextArea.setText(macro);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No macro was selected!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_loadMacroButtonActionPerformed

    private void clearMacroNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMacroNameActionPerformed
        macro = "";
        currentMacroTextArea.setText(macro);
        macroOutputTextField.setText(macro);
    }//GEN-LAST:event_clearMacroNameActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
        clearMacroNameActionPerformed(evt);
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFormulaButton;
    private javax.swing.JComboBox availableMacrosComboBox;
    private javax.swing.JLabel availableMacrosPanel;
    private javax.swing.JButton clearMacroName;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel currentMacroPanel;
    private javax.swing.JTextArea currentMacroTextArea;
    private javax.swing.JComboBox formulaComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton loadMacroButton;
    private javax.swing.JTextField macroOutputTextField;
    private javax.swing.JButton runMacroButton;
    private javax.swing.JButton saveMacroButton;
    // End of variables declaration//GEN-END:variables
}
