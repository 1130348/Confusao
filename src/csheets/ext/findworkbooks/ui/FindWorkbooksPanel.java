/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.io.Codec;
import csheets.io.CodecFactory;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksPanel extends JPanel {

    public static JList foundWorkbooksList = new JList();

    private UIController uiController;

    List<Integer> listInt = new ArrayList<>();
    
    List<JTable> listTable = new ArrayList<>();
    
    private Object columnNames[] = { "Row", "Column", "Content"};
    
    private JTabbedPane tabbedPane;
    
    private Workbook workbook;
    
    private JButton jb1;
    
    private JButton jb2;
    
    public FindWorkbooksPanel(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;

        initComponents();
        openFoundWorkbook();
    }

    private void initComponents() {
        
        JScrollPane scrollPane = new JScrollPane();        
        scrollPane.setViewportView(foundWorkbooksList);  
        scrollPane.setPreferredSize(new Dimension(300,100));
        add(scrollPane,BorderLayout.NORTH);
        
        
        
        JPanel jpanel1 = new JPanel();
        tabbedPane = new JTabbedPane();
        JTable table = new JTable(new DefaultTableModel(4, 4));
        table.setBackground(Color.red);
        JScrollPane scrollPane1 = new JScrollPane(table);
       
        jpanel1.add(tabbedPane,BorderLayout.NORTH);
        JPanel jpanelbutoes = new JPanel();
        jb1 = new JButton("Load More");
        jb1.setEnabled(false);
        jb2 = new JButton("Open");
        jb2.setEnabled(false);
        jpanelbutoes.add(jb1,BorderLayout.WEST);
        jpanelbutoes.add(jb2,BorderLayout.EAST);
        jpanel1.add(jpanelbutoes,BorderLayout.CENTER);
        add(jpanel1);
        
         jb1.addMouseListener(new MouseAdapter() {
              @Override
                public void mouseClicked(MouseEvent evt) {
                    updateTable();
                }
        }); 
        jb2.addMouseListener(new MouseAdapter() {
              @Override
                public void mouseClicked(MouseEvent evt) {
                    
                    uiController.setActiveWorkbook(workbook);
                }
        }); 
    }

    private void openFoundWorkbook() {
        if (foundWorkbooksList != null) {
            foundWorkbooksList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        Workbook book = new Workbook();
                        CleanSheets app = uiController.getApp();
                        File file = new File(foundWorkbooksList.getSelectedValue().toString());
                        if (file.exists()) {
                            FileInputStream fis =null;
                            try {
                                fis = new FileInputStream(file);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(FindWorkbooksPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Codec codec = new CodecFactory().getCodec(file);
                            try {
                                workbook = codec.read(fis);
                            } catch (IOException ex) {
                                Logger.getLogger(FindWorkbooksPanel.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(FindWorkbooksPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //EditTeste et = new EditTeste(workbook, uiController);
                            //et.setVisible(true);
                            
                            makeTables(workbook.getSpreadsheetCount(),workbook);
                            jb1.setEnabled(true);
                            jb2.setEnabled(true);
                        }
                    }
                }
            });
        }
    }
    
    
     protected void makeTables (int numSheets, Workbook w)
    {
     listInt.clear();
     listTable.clear();
     tabbedPane.removeAll();
     for (int i = 0; i < numSheets; i++) {
            Spreadsheet tmp = w.getSpreadsheet(i);
            
            int cont=0;
            
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 128; k++) {
                    if(!tmp.getCell(k,j).getContent().isEmpty())
                    {
                        cont++;
                        if(cont==4)
                        {
                            break;
                        }
                    }
                }
                if(cont==4)
                {
                  break;
                }
            }
            
            Object rowData[][] = new Object[cont][3];
            int cont1=0;
            
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 128; k++) {
                    if(!tmp.getCell(k,j).getContent().isEmpty())
                    {
                        Cell c = tmp.getCell(k,j);
                        int letter =  c.getAddress().getColumn();
                        if(letter <= 25)
                        {
                            rowData[cont1][1]= (char) (letter +65);
                        }else {
                            rowData[cont1][1]= "A" + ((char) ((letter % 25)+65)-1);
                        }
                        rowData[cont1][0]= c.getAddress().getRow()+1;
                        rowData[cont1][2]= c.getContent();
                        cont1++;
                        if(cont1==4)
                        {
                            break;
                        }
                    }
                }
                if(cont1==4)
                {
                  break;
                }
            }
            JTable table = new JTable(new DefaultTableModel(rowData, columnNames));
            listTable.add(table);
            listInt.add(2);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(400,100));
            tabbedPane.addTab(tmp.getTitle(), null, scrollPane,
                tmp.getTitle());
        }
 }
 
 protected void updateTable(){
     int i = tabbedPane.getSelectedIndex();
     int var = listInt.get(i);
     
            Spreadsheet tmp =  workbook.getSpreadsheet(i);
            
            int cont=0;
           
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 128; k++) {
                    if(!tmp.getCell(k,j).getContent().isEmpty())
                    {
                        cont++;
                        if(cont==(4*var))
                        {
                            break;
                        }
                    }
                }
                if(cont==(4*var))
                {
                  break;
                }
            }
            int num = (cont-(4*(var-1)));
            if(num>0)
            {
               
                Object rowData[][] = new Object[num][3];
                int cont1=0;
                int cont2=0;
                for (int j = 0; j < 52; j++) {
                    for (int k = 0; k < 128; k++) {
                        if(!tmp.getCell(k,j).getContent().isEmpty())
                        {
                            if(cont1>=(4*(var-1)))
                            {
                                Cell c = tmp.getCell(k,j);
                                int letter =  c.getAddress().getColumn();
                                if(letter <= 25)
                                {
                                    rowData[cont2][1]= (char) (letter +65);
                                }else {
                                    rowData[cont2][1]= "A" + ((char) ((letter % 25)+65)-1);
                                }
                                rowData[cont2][0]= c.getAddress().getRow()+1;
                                rowData[cont2][2]= c.getContent();
                                DefaultTableModel d = (DefaultTableModel) listTable.get(i).getModel();
                                d.addRow(rowData[cont2]);
                                cont2++;
                            }
                            cont1++;
                            if(cont2==num)
                            {
                                break;
                            }
                        }
                    }
                    if(cont2==num)
                    {
                      break;
                    }
                }
           JOptionPane.showMessageDialog(tabbedPane,"Now u can see "+num+" more cells of this sheet.", "Advanced WorkBook Search", JOptionPane.INFORMATION_MESSAGE);
        } else {
           JOptionPane.showMessageDialog(tabbedPane,"This sheet doesn't have more cells to show.", "Advanced WorkBook Search", JOptionPane.INFORMATION_MESSAGE);
        }
     
     listInt.set(i, (listInt.get(i)+1));
 }
 
}
