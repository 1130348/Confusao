/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

/**
 * This class is a Factory that returns all Repositories existents
 * @author rddm
 */
public class RepositoryFactory {

    /**
     * Constructor
     */
    public RepositoryFactory() {
    }
    
    /**
     * Method to get Contact Repository
     * @return Contact Repository
     */
    public ContactRepository getContactRepository(){
        return new ContactRepositoryImpl();
    }
}
