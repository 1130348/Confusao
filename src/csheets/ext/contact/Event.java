/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rddm
 */
@Entity
public class Event {
    /**
     * id of event
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**
     * Description of event
     */
    private String description;
    
    /**
     * Timestamp of event
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    protected Event() {
    }
    
    
}
