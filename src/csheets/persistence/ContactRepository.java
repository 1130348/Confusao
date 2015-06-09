/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

import csheets.ext.contact.Contact;
import java.util.List;

/**
 * Interface with methods to manage data in repository
 * @author rddm
 */
public interface ContactRepository {
    /**
     * Add contact to repository
     * @param contact contact to be added
     * @return True if is successful, False if isn't
     */
    boolean add(Contact contact);
    
     /**
     * Remove contact from repository
     * @param contact contact to be removed
     * @return True if is successful, False if isn't
     */
    boolean remove(Contact contact);
    
     /**
     * Edit contact in repository
     * @param contact contact to be edited
     * @return True if is successful, False if isn't
     */
    boolean edit(Contact contact);
    
    /**
     * Return all contacts in repository
     * @return list with all contacts in repository
     */
    List<Contact> all();
}
