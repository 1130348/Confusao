/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts.ui;

import csheets.ext.edit_alerts.Alert;
import csheets.ext.edit_alerts.EditAlertsController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class EditAlertsDialog extends javax.swing.JDialog {

    private static EditAlertsDialog instance;

    private EditAlertsController controller;

    private ArrayList<Alert> alertsList;

    private boolean comboBoxCanBeSelected = false;

    public static synchronized EditAlertsDialog getInstance(java.awt.Frame parent, boolean modal) {
        if (instance == null) {
            return instance = new EditAlertsDialog(parent, modal);
        }
        return instance;
    }

    /**
     * Creates new form EditAlertsDialo
     *
     * @param parent
     * @param modal
     */
    private EditAlertsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        controller = new EditAlertsController();
        initComponents();
    }

    private boolean checkInputFieldsMaximumAllowedChars() {
        if (textFieldName.getText().length() != 4
                || textFieldYear.getText().length() != 2
                || textFieldMonth.getText().length() != 2
                || textFieldDay.getText().length() != 2
                || textFieldHours.getText().length() != 2) {
            JOptionPane.showMessageDialog(
                    null,
                    "Your timestamp is not valid!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void resetWindowInputFields() {
        textFieldName.setText("");
        textFieldDescription.setText("");
        textFieldYear.setText("YYYY");
        textFieldMonth.setText("MM");
        textFieldDay.setText("DD");
        textFieldHours.setText("hh");
        textFieldMinutes.setText("mm");
        textFieldSeconds.setText("ss");
    }

    private void refreshAlertsList() {
        comboBoxAlertsList.removeAllItems();
        alertsList = controller.retrieveAlertsList();
        if (!alertsList.isEmpty()) {
            for (Alert alert : alertsList) {
                comboBoxAlertsList.addItem(alert.retrieveName());
            }
            comboBoxAlertsList.setSelectedIndex(-1);
        } else {
            panelCurrentAlerts.setEnabled(false);
            comboBoxAlertsList.setEnabled(false);
            buttonEditAlert.setEnabled(false);
            buttonDeleteAlert.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCurrentAlerts = new javax.swing.JLabel();
        buttonCreateAlert = new javax.swing.JButton();
        buttonEditAlert = new javax.swing.JButton();
        buttonDeleteAlert = new javax.swing.JButton();
        panelAlert = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelDescription = new javax.swing.JLabel();
        labelTimestamp = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        textFieldYear = new javax.swing.JTextField();
        labelDateSeparator1 = new javax.swing.JLabel();
        textFieldMonth = new javax.swing.JTextField();
        labelDateSeparator2 = new javax.swing.JLabel();
        textFieldDay = new javax.swing.JTextField();
        labelTime = new javax.swing.JLabel();
        textFieldHours = new javax.swing.JTextField();
        labelTimeSeparator1 = new javax.swing.JLabel();
        textFieldMinutes = new javax.swing.JTextField();
        labelTimeSeparator2 = new javax.swing.JLabel();
        textFieldSeconds = new javax.swing.JTextField();
        textFieldDescription = new javax.swing.JTextField();
        buttonClose = new javax.swing.JButton();
        comboBoxAlertsList = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alerts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelCurrentAlerts.setText("Current Alerts:");
        panelCurrentAlerts.setEnabled(false);

        buttonCreateAlert.setText("Create Alert");
        buttonCreateAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateAlertActionPerformed(evt);
            }
        });

        buttonEditAlert.setText("Edit Alert");
        buttonEditAlert.setEnabled(false);
        buttonEditAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditAlertActionPerformed(evt);
            }
        });

        buttonDeleteAlert.setText("Delete Alert");
        buttonDeleteAlert.setEnabled(false);
        buttonDeleteAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAlertActionPerformed(evt);
            }
        });

        panelAlert.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelName.setText("Name:");

        labelDescription.setText("Description (optional):");

        labelTimestamp.setText("Timestamp:");

        labelDate.setText("Date:");

        textFieldYear.setText("YYYY");
        textFieldYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldYearFocusGained(evt);
            }
        });

        labelDateSeparator1.setText("-");

        textFieldMonth.setText("MM");
        textFieldMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldMonthFocusGained(evt);
            }
        });

        labelDateSeparator2.setText("-");

        textFieldDay.setText("DD");
        textFieldDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldDayFocusGained(evt);
            }
        });

        labelTime.setText("Time:");

        textFieldHours.setText("hh");
        textFieldHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldHoursFocusGained(evt);
            }
        });

        labelTimeSeparator1.setText(":");

        textFieldMinutes.setText("mm");
        textFieldMinutes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldMinutesFocusGained(evt);
            }
        });

        labelTimeSeparator2.setText(":");

        textFieldSeconds.setText("ss");
        textFieldSeconds.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldSecondsFocusGained(evt);
            }
        });

        javax.swing.GroupLayout panelAlertLayout = new javax.swing.GroupLayout(panelAlert);
        panelAlert.setLayout(panelAlertLayout);
        panelAlertLayout.setHorizontalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldName)
                    .addComponent(textFieldDescription)
                    .addGroup(panelAlertLayout.createSequentialGroup()
                        .addGroup(panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelDescription)
                            .addComponent(labelTimestamp)
                            .addComponent(labelDate)
                            .addComponent(labelTime)
                            .addGroup(panelAlertLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAlertLayout.createSequentialGroup()
                                        .addComponent(textFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelDateSeparator1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelDateSeparator2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAlertLayout.createSequentialGroup()
                                        .addComponent(textFieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelTimeSeparator1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelTimeSeparator2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlertLayout.setVerticalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTimestamp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDateSeparator1)
                    .addComponent(textFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDateSeparator2)
                    .addComponent(textFieldDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTimeSeparator1)
                    .addComponent(textFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTimeSeparator2)
                    .addComponent(textFieldSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        comboBoxAlertsList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "There are no alerts" }));
        comboBoxAlertsList.setEnabled(false);
        comboBoxAlertsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAlertsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBoxAlertsList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelCurrentAlerts)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonEditAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonDeleteAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonCreateAlert)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCurrentAlerts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxAlertsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditAlert)
                    .addComponent(buttonDeleteAlert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreateAlert)
                    .addComponent(buttonClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateAlertActionPerformed
        String hours = textFieldHours.getText();
        try {
            controller.addAlert(
                    textFieldName.getText(),
                    textFieldDescription.getText(),
                    textFieldYear.getText(),
                    textFieldMonth.getText(),
                    textFieldDay.getText(),
                    textFieldHours.getText(),
                    textFieldMinutes.getText(),
                    textFieldSeconds.getText()
            );
        } catch (NumberFormatException number) {
            JOptionPane.showMessageDialog(
                    null,
                    "Date and time can only contain numbers!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        } catch (IllegalArgumentException illegal) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid date or time!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        resetWindowInputFields();
        refreshAlertsList();
        comboBoxAlertsList.setEnabled(true);
        panelCurrentAlerts.setEnabled(true);
        buttonDeleteAlert.setEnabled(true);
        buttonEditAlert.setEnabled(true);
        comboBoxCanBeSelected = true;
    }//GEN-LAST:event_buttonCreateAlertActionPerformed

    private void textFieldYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldYearFocusGained
        textFieldYear.selectAll();
    }//GEN-LAST:event_textFieldYearFocusGained

    private void textFieldMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldMonthFocusGained
        textFieldMonth.selectAll();
    }//GEN-LAST:event_textFieldMonthFocusGained

    private void textFieldDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldDayFocusGained
        textFieldDay.selectAll();
    }//GEN-LAST:event_textFieldDayFocusGained

    private void textFieldHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldHoursFocusGained
        textFieldHours.selectAll();
    }//GEN-LAST:event_textFieldHoursFocusGained

    private void textFieldMinutesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldMinutesFocusGained
        textFieldMinutes.selectAll();
    }//GEN-LAST:event_textFieldMinutesFocusGained

    private void textFieldSecondsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldSecondsFocusGained
        textFieldSeconds.selectAll();
    }//GEN-LAST:event_textFieldSecondsFocusGained

    private void comboBoxAlertsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAlertsListActionPerformed
        if (comboBoxCanBeSelected && comboBoxAlertsList.getSelectedIndex() != -1) {
            Alert alert = alertsList.get(comboBoxAlertsList.getSelectedIndex());
            Calendar date = alert.retrieveTimeStamp();
            textFieldName.setText(alert.retrieveName());
            textFieldDescription.setText(alert.retrieveDescription());
            textFieldYear.setText(String.valueOf(date.get(Calendar.YEAR)));
            textFieldMonth.setText(String.valueOf(date.get(Calendar.MONTH) + 1));
            textFieldDay.setText(String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
            textFieldHours.setText(String.valueOf(date.get(Calendar.HOUR)));
            textFieldMinutes.setText(String.valueOf(date.get(Calendar.MINUTE)));
            textFieldSeconds.setText(String.valueOf(date.get(Calendar.SECOND)));
        }
    }//GEN-LAST:event_comboBoxAlertsListActionPerformed

    private void buttonEditAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditAlertActionPerformed
        int index = comboBoxAlertsList.getSelectedIndex();
        controller.editAlertName(index, textFieldName.getText());
        controller.editAlertDescription(index, textFieldDescription.getText());
        Calendar timestamp = new GregorianCalendar(
                Integer.parseInt(textFieldYear.getText()),
                Integer.parseInt(textFieldMonth.getText()) - 1,
                Integer.parseInt(textFieldDay.getText()),
                Integer.parseInt(textFieldHours.getText()),
                Integer.parseInt(textFieldMinutes.getText()),
                Integer.parseInt(textFieldSeconds.getText())
        );
        controller.editAlertTimestamp(index, timestamp);
        refreshAlertsList();
        resetWindowInputFields();
    }//GEN-LAST:event_buttonEditAlertActionPerformed

    private void buttonDeleteAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAlertActionPerformed
        controller.removeAlert(comboBoxAlertsList.getSelectedIndex());
        resetWindowInputFields();
        refreshAlertsList();
    }//GEN-LAST:event_buttonDeleteAlertActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
        resetWindowInputFields();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        resetWindowInputFields();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonCreateAlert;
    private javax.swing.JButton buttonDeleteAlert;
    private javax.swing.JButton buttonEditAlert;
    private javax.swing.JComboBox comboBoxAlertsList;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDateSeparator1;
    private javax.swing.JLabel labelDateSeparator2;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelTimeSeparator1;
    private javax.swing.JLabel labelTimeSeparator2;
    private javax.swing.JLabel labelTimestamp;
    private javax.swing.JPanel panelAlert;
    private javax.swing.JLabel panelCurrentAlerts;
    private javax.swing.JTextField textFieldDay;
    private javax.swing.JTextField textFieldDescription;
    private javax.swing.JTextField textFieldHours;
    private javax.swing.JTextField textFieldMinutes;
    private javax.swing.JTextField textFieldMonth;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldSeconds;
    private javax.swing.JTextField textFieldYear;
    // End of variables declaration//GEN-END:variables
}
