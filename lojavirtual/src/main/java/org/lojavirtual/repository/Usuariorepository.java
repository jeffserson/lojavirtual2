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
import org.lojavirtual.Produto;
import org.lojavirtual.Usuario;
@Stateless 
public class Usuariorepository implements Serializable {
    


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void excluirusuario(Usuario usuario){
		
		this.manager.remove(usuario);
			
         }
	
	public Usuario porid(Long id) {
		return manager.find(Usuario.class, id);
	}
	public Usuario guardar(Usuario usuario){
		 return manager.merge(usuario);
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
	public Usuario poremail(String email) {
		try {
			return manager.createQuery("from Usuario where upper(email) = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}	
	}
}

