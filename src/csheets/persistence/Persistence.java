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
public final class Persistence {
   
    /**
     * Constructor
     */
    private Persistence() {
    }

    /**
     * Return the Repository Factory
     * @return Repository Factory
     */
    public static RepositoryFactory getRepositoryFactory() {
            return new RepositoryFactory();
    }
}
