/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DMMCA
 */
public class FormEditorController {

    public static UIController ui;

    private UIController uiController;

    /**
     * MenuBarFormEditor interface menu *
     */
    private MenuBarFormEditor MBFE;

    private static FormEditorUI FEUI;
    
    private static EditFormUI EFUI;

    static ArrayList<Form> FormsList = new ArrayList();

    /**
     * Creates a new Form Editor controller.
     *
     * @param uiController the Form Editor interface controller
     * @param uiPanel the Form Editor interface panel
     */
    public FormEditorController(UIController uiController,
                                MenuBarFormEditor MBFE) {
        this.uiController = uiController;
        this.ui = uiController;
        this.MBFE = MBFE;
    }

    public void CreateForm() {
        FEUI = new FormEditorUI(this);
        FEUI.setAlwaysOnTop(true);
    }

    public void Edit() {
        EFUI = new EditFormUI(this);
        EFUI.setAlwaysOnTop(true);

    }
    JComboBox<String> forms;

    public void Display() {

        JFrame f = new JFrame("Display Form");
        f.setLayout(null);
        JLabel title = new JLabel("Choose one of the following forms:");
        title.setBounds(20, 20, 210, 20);
        f.add(title);

        forms = new JComboBox();
        forms.setBounds(25, 50, 200, 25);
        int i = 0;
        for (Form ff : FormsList) {

            if (ff.getActiveSpreadSheet().equals(uiController.
                getActiveSpreadsheet())) {
                forms.addItem(i + " ) " + ff.getName());
            }
            i++;
        }

        JButton b = new JButton("Display");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FormsList.get(Integer.parseInt(forms.getSelectedItem().
                    toString().substring(0, forms.getSelectedItem().toString().
                                         indexOf(" ")))).Display();

            }
        });
        b.setBounds(75, 100, 100, 30);
        f.add(b);
        f.add(forms);
        f.setLocationRelativeTo(null);
        f.setSize(new Dimension(250, 200));
        f.setDefaultCloseOperation(1);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void Display(Value value) {

        for (Form FormsList1 : FormsList) {
            final Cell c = ui.getActiveCell();
            if (FormsList1.getName().compareTo(value.toString()) == 0) {
                FormsList1.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        c.clear();
                    }
                });
                FormsList1.Display();
            }
        }
    }

    public void addForm(Form nf) {
        FormsList.add(nf);
    }

    public void Remove() {
        final JFrame d = new JFrame("Remove Form");
        d.setLayout(null);
        JLabel title = new JLabel("Choose one of the following forms:");
        title.setBounds(20, 20, 210, 20);
        d.add(title);

        forms = new JComboBox();
        forms.setBounds(25, 50, 200, 25);
        int i = 0;
        for (Form ff : FormsList) {

            if (ff.getActiveSpreadSheet().equals(uiController.
                getActiveSpreadsheet())) {
                forms.addItem(i + " ) " + ff.getName());
            }
            i++;
        }

        JButton b = new JButton("Remove Form");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FormsList.remove(Integer.parseInt(forms.getSelectedItem().
                    toString().substring(0, forms.getSelectedItem().toString().
                                         indexOf(" "))));

                d.dispose();

            }
        });
        b.setBounds(75, 100, 100, 30);
        
        d.add(b);
        d.add(forms);
        d.setDefaultCloseOperation(1);
        d.setLocationRelativeTo(null);
        d.setSize(new Dimension(250, 200));
        d.setResizable(false);
        d.setVisible(true);
    }

}
