/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author rddm
 */
@Entity
public class Contact {
    /**
     * Id of contact
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * First name of contact
     */
    private String firstName;
    /**
     * Last name of contact
     */
    private String lastName;
    /**
     * Agenda of contact
     */
    @OneToOne
    private Agenda agenda;
}
