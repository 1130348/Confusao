/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.crm;

import java.util.List;
import javax.persistence.ManyToOne;

/**
 * Agenda is a class who saves all events
 * @author rddm
 */
class Agenda {
    /**
     * List of Events;
     */
    @ManyToOne
    private List<Event> listEvent;
    
    protected Agenda(){
        
    }
}
