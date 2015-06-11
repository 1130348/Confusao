/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio Pinheiro
 */
@Entity
public class Notes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Note> noteList;
    
    public Notes()
    {
        noteList = new ArrayList<Note>();
    }
    
    public boolean addNote(Note n)
    {
        return getNoteList().add(n);
    }
    
    public boolean removeNote(Note n)
    {
        for (Note tmp : getNoteList()) {
			if (Integer.toHexString(System.
				identityHashCode(tmp)).equals(Integer.toHexString(System.
						identityHashCode(n)))) {
				return getNoteList().remove(tmp);
			}
		}
		return false;
    }

    /**
     * @return the noteList
     */
    public List<Note> getNoteList() {
        return noteList;
    }

    /**
     * @param noteList the noteList to set
     */
    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
