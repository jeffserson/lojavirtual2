package org.lojavirtual.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Produto;
import org.lojavirtual.service.Produtoservice;
import org.lojavirtual.util.FacesUtil;

@Named
@ViewScoped
public class Produtocontroller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto ; 
	
	@Inject
	private Produtoservice produtoservice;
	
	
	public void prepararproduto() {
		if(this.produto == null){
		produto = new Produto();
		}
	}
	
    public void salvar(){
    	this.produto = produtoservice.salvar(this.produto);
        FacesUtil.addInfoMessage("Produto salvo com sucesso");	
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
    
		
	
}
