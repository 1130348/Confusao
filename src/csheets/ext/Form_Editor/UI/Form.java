/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import csheets.core.Spreadsheet;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DMMCA
 */
public class Form extends JFrame {

    private Spreadsheet activeSpreadSheet;
    private String description;
    private GroupLayout gl_contentPanel;
    private List<JComponent> ar = new ArrayList();
    private JPanel grid;

    public Form(Spreadsheet spdst, String name, String desc) {
        this.activeSpreadSheet = spdst;
        this.description = desc;
        setDefaultCloseOperation(1);
        setTitle(name);
        setName(name);
        setResizable(false);
        setLocationRelativeTo(null);
        grid = new JPanel(new GridLayout(0, 1));
        add(grid);
        setMinimumSize(new Dimension(100, 100));

    }

    public void addElements(JComponent a, JComponent b) {
        JPanel temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ar.add(a);
        temp.add(a);
        ar.add(b);
        temp.add(b);
        grid.add(temp);
        pack();
    }

    public Spreadsheet getActiveSpreadSheet() {
        return activeSpreadSheet;
    }

    public String getDescription() {
        return description;
    }

    public void Display() {
        setVisible(true);
        setAlwaysOnTop(true);
    }

    public List<JComponent> getAllComponents() {
        return ar;
    }
}
