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
    
    private final String PERSISTENCE_UNIT_NAME="cleansheetsPU";

    private Persistence() {
    }

    public static RepositoryFactory getRepositoryFactory() {
            return new RepositoryFactory();
    }
}
