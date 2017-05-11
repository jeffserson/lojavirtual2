package org.lojavirtual.repository;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;
import org.lojavirtual.Cliente;
import org.lojavirtual.Grupo;
import org.lojavirtual.Usuario;
@Stateless 
public class Usuariorepository implements Serializable {
    


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Usuario porid(Long id) {
		return manager.find(Usuario.class, id);
	}
	public Usuario logar(String email){
		try {
			TypedQuery<Usuario> query = manager.createQuery("select p from Usuario p  "+ 
			          "where p.email= :pEmail ", Usuario.class);
			           query.setHint(QueryHints.CACHEABLE, true);
			           query.setParameter("pEmail" ,email);
			     
			          return query.getSingleResult();
		      
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
		  
     
		
			
}
	
	

}
