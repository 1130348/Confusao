/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author DMMCA
 */
public class EditFormUI extends JFrame {

    private FormEditorController CTRL;
    private Form selectedForm;
    private JComponent SelectedComponent;
    private int styled;
    private int width, height;

    public EditFormUI(final FormEditorController CTRL) {
        try {
            this.CTRL = CTRL;
            setTitle("Edit Form");
            setLayout(null);

            JButton pp = new JButton("Preview");
            pp.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedForm.Display();
                }
            });
            pp.setBounds(170, 480, 80, 30);
            add(pp);

            JLabel titleForms = new JLabel("Choose one Form to Edit:");
            titleForms.setBounds(20, 20, 210, 20);
            add(titleForms);

            final JComboBox forms = new JComboBox();
            forms.setBounds(25, 50, 200, 25);
            int i = 0;
            final JComboBox Components = new JComboBox();
            Components.setBounds(25, 100, 200, 25);
            //forms.addItem("00 ) Select one");
            for (Form ff : FormEditorController.FormsList) {

                if (ff.getActiveSpreadSheet().equals(CTRL.ui.
                    getActiveSpreadsheet())) {
                    forms.addItem(i + " ) " + ff.getName());
                }
                i++;
            }
            if (forms.getItemCount() != 0) {
                selectedForm = CTRL.FormsList.get(0);
                int j = 0;

                for (JComponent ff : selectedForm.getAllComponents()) {
                    if (ff instanceof JButton) {
                        Components.
                            addItem(j + " ) " + ((JButton) ff).getText() + " | JButton");
                    }
                    if (ff instanceof JLabel) {
                        Components.
                            addItem(j + " ) " + ((JLabel) ff).getText() + " | JLabel");
                    }
                    if (ff instanceof JTextField) {
                        Components.
                            addItem(j + " ) " + ((JTextField) ff).getText() + " | JTextField");
                    }

                    j++;
                }
            }
            if (selectedForm.getAllComponents().size() != 0) {
                SelectedComponent = selectedForm.getAllComponents().get(0);
            }
            ItemListener itemListener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent itemEvent) {
                    if (Components.getItemCount() != 0) {
                        Components.removeAllItems();
                    }
                    int state = itemEvent.getStateChange();
                    selectedForm = CTRL.FormsList.get(Integer.
                        parseInt(itemEvent.
                            getItem().toString().substring(0, forms.
                                                           getSelectedItem().
                                                           toString().
                                                           indexOf(" "))));
                    int j = 0;

                    for (JComponent ff : selectedForm.getAllComponents()) {
                        if (ff instanceof JButton) {
                            Components.
                                addItem(j + " ) " + ((JButton) ff).getText() + " | JButton");
                        }
                        if (ff instanceof JLabel) {
                            Components.
                                addItem(j + " ) " + ((JLabel) ff).getText() + " | JLabel");
                        }
                        if (ff instanceof JTextField) {
                            Components.
                                addItem(j + " ) " + ((JTextField) ff).getText() + " | JTextField");
                        }

                        j++;
                    }

                }

            };

            ItemListener itemListenerComp = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent itemEvent) {
                    SelectedComponent = selectedForm.getAllComponents().
                        get(Integer.
                            parseInt(itemEvent.
                                getItem().toString().substring(0, forms.
                                                               getSelectedItem().
                                                               toString().
                                                               indexOf(" "))));

                }

            };

            Components.addItemListener(itemListenerComp);
            add(Components);
            add(forms);

            JLabel titleComponents = new JLabel("Choose one Component to Edit:");
            titleComponents.setBounds(20, 80, 210, 20);
            add(titleComponents);

            /* EDITING COMPONENTS STYLING*/
            JPanel cf = new JPanel();
            cf.setBounds(0, 150, 380, 150);
            cf.setBorder(BorderFactory.createTitledBorder("Fonts Styling"));
            JLabel fad = new JLabel();
            fad.setText("Style:");
            JComboBox style = new JComboBox();
            style.addItem("1 ) Bold");
            style.addItem("2 ) Italic");
            style.addItem("3 )Normal");
            style.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    styled = Integer.parseInt(e.getItem().toString().
                        substring(0, 1));
                }
            });
            fad.setBounds(20, 180, 80, 20);
            style.setBounds(100, 180, 100, 20);
            add(style);
            add(fad);
            

            JLabel qw = new JLabel();
            qw.setText("Size:");
            qw.setBounds(20, 200, 80, 20);
            add(qw);
            final JSpinner js = new JSpinner(new SpinnerNumberModel(10, 10, 20, 1));
            js.setBounds(100, 200, 50, 20);
            add(js);
            JButton sd = new JButton("Apply");
            sd.setBounds(295, 265, 80, 30);
            sd.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(styled);
                    SelectedComponent.
                        setFont(new Font("Dialog", styled, Integer.parseInt(js.
                                             getValue().toString())));
                    selectedForm.pack();
                }
            });
            add(sd);
            add(cf);

            JPanel df = new JPanel();
            df.setBounds(0, 300, 380, 150);
            df.setBorder(BorderFactory.
                createTitledBorder("Width/Height Styling"));

            JLabel qs = new JLabel();
            qs.setText("Width:");
            qs.setBounds(20, 320, 80, 20);
            add(qs);
            final JSpinner jw = new JSpinner(new SpinnerNumberModel(10, 10, 60, 1));
            jw.setBounds(100, 320, 50, 20);
            add(jw);

            JLabel qsh = new JLabel();
            qsh.setText("Height:");
            qsh.setBounds(20, 355, 80, 20);
            add(qsh);
            final JSpinner jh = new JSpinner(new SpinnerNumberModel(10, 10, 60, 1));
            jh.setBounds(100, 355, 50, 20);
            add(jh);

            JButton dd = new JButton("Apply");
            dd.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    SelectedComponent.setPreferredSize(new Dimension(Integer.
                        parseInt(jw.getValue().toString()), Integer.parseInt(jh.
                                                                         getValue().
                                                                         toString())));

                    SelectedComponent.revalidate();
                    SelectedComponent.repaint();
                    
                    selectedForm.pack();
                }
            });
            dd.setBounds(295, 400, 80, 30);
            add(dd);

            add(df);

            setResizable(false);
            setLocationRelativeTo(null);
            setSize(new Dimension(400, 550));
            setVisible(true);
        } catch (NullPointerException e) {
        }

    }

}
