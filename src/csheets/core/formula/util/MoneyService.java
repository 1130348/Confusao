/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author joaomonteiro
 */
public class MoneyService {

    private static Map<String, Double> currencyExchanges = new HashMap<>();
    private static boolean currenciesLoaded = false;

    public MoneyService() {
    }

    public static void fileChoosed(boolean b) {
        currenciesLoaded = b;
    }

    public static void importCurrenciesFromCSVFile(File file) {
        try {
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(null, "csv");
            FileInputStream fIn = new FileInputStream(file);
            if (extensionFilter.accept(file)) {
                Reader streamReader = new InputStreamReader(fIn);
                BufferedReader reader = new BufferedReader(streamReader);

                String line;
                int cont = 0;
                String[] currencies = null;
                String[] exchangeValues = null;
                while ((line = reader.readLine()) != null) {
                    if (cont == 0) {
                        currencies = line.split(";");
                        cont++;
                    } else if (cont == 1) {
                        exchangeValues = line.split(";");
                        break;
                    }
                }

                if (currencies != null && exchangeValues != null) {
                    fileChoosed(true);
                    loadCurrentExchangesToMap(currencies, exchangeValues);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error importing the file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading line from file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static double searchCurrencyExchangeValue(String currency) {

        switch (currency) {
            case "$":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("dollar")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;
            case "€":
                break;
            case "£":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("pound")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "¥":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("yen")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "₩":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("won")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "₹":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("rupee")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;
            default:
                throw new AssertionError();
        }

        return 0.0d;

    }

    private static void loadCurrentExchangesToMap(String[] currencies, String[] exchangeValues) {
        for (int i = 0; i < currencies.length; i++) {
            if (exchangeValues[i].contains(",")) {
                exchangeValues[i] = exchangeValues[i].replace(",", ".");
                currencyExchanges.put(currencies[i], Double.parseDouble(exchangeValues[i]));
            }
            if (exchangeValues[i].equals("-")) {
                currencyExchanges.put(currencies[i], null);
            }
        }
    }
}
