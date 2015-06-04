/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

import csheets.crm.Contact;
import java.util.List;

/**
 * Interface with methods to manage data in repository
 * @author rddm
 */
public interface ContactRepository {
    /**
     * Add contact to repository
     * @return True if is successful, False if isn't
     */
    boolean add();
    
     /**
     * Remove contact from repository
     * @return True if is successful, False if isn't
     */
    boolean remove();
    
     /**
     * Edit contact in repository
     * @return True if is successful, False if isn't
     */
    boolean edit();
    
    /**
     * Return all contacts in repository
     * @return list with all contacts in repository
     */
    List<Contact> all();
}
