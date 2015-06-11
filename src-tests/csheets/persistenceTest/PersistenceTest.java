/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistenceTest;

/**
 *
 * @author rddm
 */
public final class PersistenceTest {
   
    /**
     * Constructor
     */
    private PersistenceTest() {
    }

    /**
     * Return the Repository Factory
     * @return Repository Factory
     */
    public static RepositoryFactoryTest getRepositoryFactory() {
            return new RepositoryFactoryTest();
    }
}
