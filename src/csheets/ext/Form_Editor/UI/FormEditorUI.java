/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author DMMCA
 */
public class FormEditorUI extends JFrame {

    private final FormEditorController CTRL;
    private JSpinner nl;
    private String name;
    private String desc;
    private Form tmp;
    private int x = 0, y = 0;
    private JPanel ac;
    private boolean go = true;
    private String[] ar = new String[2];
    private JTextField tn2, tn3;

    public FormEditorUI(final FormEditorController CTRL) {
        this.CTRL = CTRL;
        setTitle("Form Editor");
        setLayout(null);
        JPanel cf = new JPanel();
        cf.setBounds(0, 5, 393, 150);
        cf.setBorder(BorderFactory.createTitledBorder("Create Form"));

        JLabel n = new JLabel("Name:");
        n.setBounds(15, 25, 40, 20);
        add(n);
        JTextField tn = new JTextField();
        tn.setBounds(115, 25, 200, 20);
        tn.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (((JTextField) e.getSource()).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(((JTextField) e.getSource()).
                        getRootPane(), "Insert Valid Name", "Error", JOptionPane.ERROR_MESSAGE);
                    ((JTextField) e.getSource()).grabFocus();
                } else {
                    name = ((JTextField) e.getSource()).getText();
                }
            }
        });
        add(tn);
        JLabel d = new JLabel("Description:");
        d.setBounds(15, 50, 80, 20);
        add(d);
        JTextField td = new JTextField();
        td.setBounds(115, 50, 200, 20);
        td.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (((JTextField) e.getSource()).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(((JTextField) e.getSource()).
                        getRootPane(), "Insert Valid Description", "Error", JOptionPane.ERROR_MESSAGE);
                    ((JTextField) e.getSource()).grabFocus();
                } else {
                    desc = ((JTextField) e.getSource()).getText();
                }
            }
        });
        add(td);
        JLabel li = new JLabel("Number of Lines:");
        li.setBounds(15, 75, 100, 20);
        add(li);
        nl = new JSpinner();
        nl.setBounds(115, 75, 50, 20);
        nl.setModel(new SpinnerNumberModel(1, 1, 100, 1));

        add(nl);

        JButton set = new JButton("Set");
        set.setBounds(155, 110, 80, 30);
        set.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.equalsIgnoreCase(null) && !desc.equalsIgnoreCase(null)) {
                    tmp = new Form(CTRL.ui.getActiveSpreadsheet(), name, desc);
                    y = Integer.parseInt(nl.getValue().toString());
                    ac.setBorder(BorderFactory.
                        createTitledBorder("Add Component " + x + " of " + y));
                    ac.setOpaque(false);
                }
            }
        });
        add(set);
        add(cf);

        //----------------------------------Second Panel---------------------------------
        ac = new JPanel();
        ac.setBounds(0, 160, 393, 180);
        ac.setBorder(BorderFactory.
            createTitledBorder("Add Component " + x + " of " + y));

        ButtonGroup groupR = new ButtonGroup();
        ButtonGroup groupL = new ButtonGroup();

        tn2 = new JTextField();
        tn2.setBounds(15, 200, 140, 20);
        add(tn2);

        JLabel n2 = new JLabel("Name");
        n2.setBounds(180, 205, 40, 10);
        add(n2);

        tn3 = new JTextField();
        tn3.setBounds(240, 200, 140, 20);
        add(tn3);

        JRadioButton rjll = new JRadioButton();
        rjll.setBounds(80, 244, 40, 15);
        groupL.add(rjll);
        add(rjll);

        JLabel jl = new JLabel("JLabel");
        jl.setBounds(177, 245, 40, 10);
        add(jl);

        JRadioButton rjlr = new JRadioButton();
        rjlr.setBounds(300, 244, 40, 15);
        groupR.add(rjlr);
        add(rjlr);

        JRadioButton rjtfl = new JRadioButton();
        rjtfl.setBounds(80, 274, 60, 15);
        groupL.add(rjtfl);
        add(rjtfl);

        JLabel jtf = new JLabel("JTextField");
        jtf.setBounds(168, 275, 60, 10);
        add(jtf);

        JRadioButton rjtfr = new JRadioButton();
        rjtfr.setBounds(300, 274, 60, 15);
        groupR.add(rjtfr);
        add(rjtfr);

        JRadioButton rjbl = new JRadioButton();
        rjbl.setBounds(80, 304, 50, 15);
        groupL.add(rjbl);
        add(rjbl);

        JLabel jb = new JLabel("JButton");
        jb.setBounds(175, 305, 50, 10);
        add(jb);

        JRadioButton rjbr = new JRadioButton();
        rjbr.setBounds(300, 304, 50, 15);
        groupR.add(rjbr);
        add(rjbr);

        rjbl.setActionCommand("LJButton");
        rjbr.setActionCommand("RJButton");
        rjtfl.setActionCommand("LJTextField");
        rjtfr.setActionCommand("RJTextField");
        rjll.setActionCommand("LJLabel");
        rjlr.setActionCommand("RJLabel");

        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().startsWith("L")) {
                    ar[0] = e.getActionCommand().substring(1, e.
                                                           getActionCommand().
                                                           length());
                } else {
                    ar[1] = e.getActionCommand().substring(1, e.
                                                           getActionCommand().
                                                           length());
                }
            }
        };

        rjbl.addActionListener(action);
        rjbr.addActionListener(action);
        rjtfl.addActionListener(action);
        rjtfr.addActionListener(action);
        rjll.addActionListener(action);
        rjlr.addActionListener(action);

        add(ac);

        //--------------------------------------------End Second Panel---------------------------------
        JButton preview = new JButton("Preview");
        preview.setBounds(15, 350, 80, 30);
        preview.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tmp.Display();
            }
        });
        add(preview);

        JButton finish = new JButton("Save");
        finish.setBounds(220, 350, 80, 30);
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CTRL.addForm(tmp);
                dispose();
            }
        });
        add(finish);

        JButton next = new JButton("Next");
        next.setBounds(300, 350, 80, 30);
        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x < y) {
                    int i = 0;
                    JComponent[] tmps = new JComponent[2];
                    String[] t = new String[2];
                    t[0] = tn2.getText();
                    t[1] = tn3.getText();
                    while (i <= 1) {
                        switch (ar[i]) {
                            case "JButton":
                                System.out.println(t[i]);
                                tmps[i] = new JButton(t[i]);
                                break;

                            case "JTextField":
                                tmps[i] = new JTextField(t[i]);
                                break;

                            case "JLabel":
                                tmps[i] = new JLabel(t[i]);
                                break;
                        }

                        i++;
                    }
                    ac.setBorder(BorderFactory.
                        createTitledBorder("Add Component " + (x + 1) + " of " + y));
                    ac.setOpaque(false);
                    x++;
                    System.out.println(x + ">>>>>");
                    tmp.addElements(tmps[0], tmps[1]);
                }
            }
        });
        add(next);

        setSize(400, 420);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(1);
        setLocationRelativeTo(null);
    }
}
