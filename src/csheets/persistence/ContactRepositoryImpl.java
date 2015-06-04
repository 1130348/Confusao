package csheets.persistence;

import csheets.ext.contact.Contact;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class implements the interface ContactRepository and the template class
 * JpaRepository
 *
 * @author rddm
 */
public class ContactRepositoryImpl extends JpaRepository<Contact, String> implements ContactRepository {

	@Override
	public boolean add(Contact contact) {
		try {
			super.add(contact);
		} catch (RollbackException ex) {
			throw new IllegalStateException();
		}
		return true;
	}

	@Override
	public boolean remove(Contact contact) {
		try {
			super.remove(contact);
		} catch (RollbackException ex) {
			throw new IllegalStateException();
		}
		return true;
	}

	@Override
	public boolean edit(Contact contact) {
		try {
			super.save(contact);
		} catch (RollbackException ex) {
			throw new IllegalStateException();
		}
		return true;
	}

	@Override
	public List<Contact> all() {
		Query q = entityManager().createQuery("SELECT it FROM Contact it");
		return q.getResultList();
	}

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}
}
