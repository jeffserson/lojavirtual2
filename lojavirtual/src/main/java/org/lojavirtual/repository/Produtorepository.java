package org.lojavirtual.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.QueryHints;

import org.lojavirtual.Produto;

public class Produtorepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
    
	public void excluirproduto(Produto produto){
		
		this.manager.remove(produto);
			
}
	public Produto porid(Long id) {
		return manager.find(Produto.class, id);
	}
    
	public Produto guardar(Produto produto){
		 return manager.merge(produto);
	}
	
	public List<Produto> todos() {
		return manager.createQuery("from Produto order by nome", Produto.class)
			    .setHint(QueryHints.CACHEABLE, true).getResultList();
	}
	public Produto porcodigo(String codigo) {
		try {
			return manager.createQuery("from Produto where upper(codigo) = :codigo", Produto.class)
				.setParameter("codigo", codigo.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
