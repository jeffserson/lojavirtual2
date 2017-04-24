package org.lojavirtual.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.lojavirtual.Cliente;
import org.lojavirtual.Produto;
import org.lojavirtual.repository.Produtorepository;
import org.lojavirtual.util.FacesUtil;

public class Produtoservice implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Produtorepository produtorepository;
	
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtorepository.porcodigo(produto.getCodigo());
		
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Já existe um produto com o CODIGO informado.");
		}
		
		return produtorepository.guardar(produto);
	}
	
	@Transactional
	public void exluirproduto(Produto produto) {
		produto = produtorepository.porid(produto.getId());
		produtorepository.excluirproduto(produto);
	}
	
	

}
