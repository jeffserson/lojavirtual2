package org.lojavirtual.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.QueryHints;
import org.lojavirtual.Grupo;

@Stateless
public class Gruporepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager em;

	public Grupo save(Grupo entity) {
		return this.em.merge(entity);
	}

	public void delete(long id) {
		try {
			Grupo reference = this.em.getReference(Grupo.class, id);
			this.em.remove(reference);
		} catch (EntityNotFoundException e) {
			// It doesn't exist already
		}
	}

	public Grupo findById(long id) {
		return this.em.find(Grupo.class, id);
	}

	

	public List<Grupo> findAll() {
		return this.em.createNamedQuery("Grupo.findAll", Grupo.class).getResultList();
	}
}
