package org.lojavirtual.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.lojavirtual.Cliente;
import org.lojavirtual.repository.Clienterepository;
import org.lojavirtual.service.ClienteService;
import org.lojavirtual.util.FacesUtil;
import org.omnifaces.cdi.ViewScoped;




@Named
@javax.faces.view.ViewScoped
public class Clientecontroler implements Serializable {
          
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente ; 
	@Inject
	private ClienteService clienteservico;
	
	
	
	public String salvar() {
		this.clienteservico.salvar(cliente);

		FacesUtil.addInfoMessage("Cliente Cadastrado com sucesso");

		return "/cliente/ClientesCadastrados?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
 public void prepararcliente() {
	 if(this.cliente==null){
		 cliente = new Cliente();
	 }
}
	
	
}
