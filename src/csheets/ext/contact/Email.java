/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rddm
 */
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Text with phone number
     */
    private String text;

    protected Email() {
    }
    
    

    /**
     * Constructor
     *
     * @param text text of email
     */
    public Email(String text) {
        if (validate(text)) {
            this.text = text;
        }
    }

    /**
     * To string of email
     *
     * @return email in String
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * Validate the text to create a email
     *
     * @param text text to be validate
     * @return true if is valid, false if isn't
     */
    public static boolean validate(String text) {
        String expression = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
        return matcher.matches();
    }
}
