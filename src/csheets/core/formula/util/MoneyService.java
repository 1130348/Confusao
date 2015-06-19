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

    public static Map<String, Double> currencyExchanges = new HashMap<>();
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
                    loadCurrencyExchangesToMap(currencies, exchangeValues);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error importing the file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading line from file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean checkFileImported() {
        return currenciesLoaded;
    }

    public static double searchCurrencyExchangeValue(String currency) {

        switch (currency) {
            case "$":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("dollar") || curr.contains("Dollar")) {
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
                    if (curr.contains("pound") || curr.contains("Pound")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "¥":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("yen") || curr.contains("Yen")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "₩":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("won") || curr.contains("Won")) {
                        if (currencyExchanges.get(curr) != null) {
                            return currencyExchanges.get(curr);
                        }
                    }
                }
                break;

            case "₹":
                for (String curr : currencyExchanges.keySet()) {
                    if (curr.contains("rupee") || curr.contains("Rupee")) {
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

    private static void loadCurrencyExchangesToMap(String[] currencies, String[] exchangeValues) {
        for (int i = 0; i < currencies.length; i++) {
            if (exchangeValues[i].equals("-")) {
                currencyExchanges.put(currencies[i], null);
            }

            exchangeValues[i] = exchangeValues[i].trim();
            if (exchangeValues[i].contains(",")) {
                exchangeValues[i] = exchangeValues[i].replace(",", ".");
                currencyExchanges.put(currencies[i], Double.parseDouble(exchangeValues[i]));
            } else {
                currencyExchanges.put(currencies[i], Double.parseDouble(exchangeValues[i]));
            }
        }
    }
}
