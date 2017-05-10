package org.lojavirtual.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;
import org.lojavirtual.Usuario;
@Stateless 
public class Usuariorepository implements Serializable {
    


	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
	
	public Usuario porid(Integer integer) {
		return manager.find(Usuario.class, integer);
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
	public void excluirusuario(Usuario usuario)
	{
		manager.remove(usuario);
	}
	
	public Usuario guardar(Usuario usuario)
	{
		return manager.merge(usuario);
	}
	
	public List<Usuario> todos(String nome)
	{
		return manager.createQuery("from Usuario where nome like :nome", Usuario.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
}
