/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

/**
 * 
 * @author rddm
 */
public class RepositoryFactory {

    public RepositoryFactory() {
    }
    
    public ContactRepository getContactRepository(){
        return new ContactRepositoryImpl();
    }
}
