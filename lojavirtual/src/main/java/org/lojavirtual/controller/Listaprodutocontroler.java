package org.lojavirtual.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Produto;
import org.lojavirtual.repository.Produtorepository;
import org.lojavirtual.service.Produtoservice;
import org.lojavirtual.util.FacesUtil;
@Named
@ViewScoped
public class Listaprodutocontroler implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produto produto;
	private List<Produto> produtos ;
	@Inject
	private Produtoservice produtoservico;
	@Inject
	private Produtorepository produtorepository;
	
	private String nome;
	
	public void excluirproduto(Produto produto) {
		 this.produto = produto;
		 produtoservico.exluirproduto(produto);
		 FacesUtil.addInfoMessage("Produto Excluido Com Sucesso");
	}
	
	public void consultarproduto() {
		produtos = this.produtorepository.todos();
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

    public void pesquisarproduto() {
		this.produtos  = this.produtorepository.porNomeSemelhante(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
   
}
