package org.lojavirtual.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import org.lojavirtual.Cliente;
import org.lojavirtual.service.ClienteService;
import org.lojavirtual.util.FacesUtil;




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
