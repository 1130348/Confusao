/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rddm
 */
public class PhoneNumber {
    
    /**
     * Text with phone number
     */
    private String text;

    /**
     * Constructor
     * @param text text of phone Number
     */
    public PhoneNumber(String text) {
        if(validate(text))
            this.text=text;
    }

    
    /**
     * To string of Phone Number
     * @return PhoneNumber in String
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * Validate the text to create a phoneNumber
     * @param text text to be validate
     * @return true if is valid, false if isn't
     */
    public static boolean validate(String text) {
        //case of no info
        if(text.isEmpty())
            return true;
        //String expression="^\\+(?:[0-9] ?){6,14}[0-9]$";
        String expression="((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}

