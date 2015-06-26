/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import java.net.InetAddress;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ContentSearchEvent {
    
    private InetAddress address;
    private String workbookName;

    public ContentSearchEvent(InetAddress address, String workbookName) {
        this.address = address;
        this.workbookName = workbookName;
    }

    public InetAddress getAddress() {
        return address;
    }

    public String getWorkbookName() {
        return workbookName;
    }
}
