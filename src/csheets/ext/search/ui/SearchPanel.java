/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search.ui;

import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Andre
 */
public class SearchPanel extends JPanel {

    public static JList addresses = new JList();
    public static List adds;
    private static int cont;
    private UIController controller;

    public SearchPanel(UIController uicontroller) {
        super(new BorderLayout());
        controller = uicontroller;
        JScrollPane scroll = new JScrollPane();
        adds = new ArrayList<>();
        cont = 0;

        scroll.setViewportView(addresses);
        add(scroll);
        openFoundMatch();
    }

    public static void addAddress(Address add) {
        adds.add((++cont) + ". " + add);
        addresses.setListData(adds.toArray());
    }

    public static void addAddressList(List<Address> list) {
        for (Address add : list) {
            adds.add(add);
            addresses.setListData(adds.toArray());
        }
    }

    public static void initComps() {
        adds.clear();
        addresses.setListData(adds.toArray());
        cont = 0;
    }

    private void openFoundMatch() {
        if (addresses != null) {
            addresses.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        Address address = (Address) addresses.getSelectedValue();
                        Spreadsheet spreadsheet = controller.getActiveSpreadsheet();
                        controller.setActiveCell(spreadsheet.getCell(address));
                    }
                }
            });
        }
    }

}
