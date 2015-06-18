/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.core.formula.util.MoneyService;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author joaomonteiro
 */
public class ChooseCurrencyExchangeFileAction extends BaseAction{

    @Override
    protected String getName() {
        return "Choose currency exchange file";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File choosedFile = fileChooser.getSelectedFile();
        
        MoneyService.importCurrenciesFromCSVFile(choosedFile);
    }
    
}
