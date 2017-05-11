package org.lojavirtual.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.QueryHints;
import org.lojavirtual.Cliente;



public class Clienterepository implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
    
	public void excluircliente1(Cliente cliente){
		
		this.manager.remove(cliente);
			
}
	public Cliente porid(Long id) {
		return manager.find(Cliente.class, id);
	}
    
	public void guardar(Cliente cliente){
		 manager.merge(cliente);
	}
	
	public List<Cliente> todos() {
		return manager.createQuery("from Cliente", Cliente.class)
			    .setHint(QueryHints.CACHEABLE, true).getResultList();
	}
	
	public List<Cliente> porNomeSemelhante(String nome) {
		return manager.createQuery("from Cliente where nome like :nome", Cliente.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
}