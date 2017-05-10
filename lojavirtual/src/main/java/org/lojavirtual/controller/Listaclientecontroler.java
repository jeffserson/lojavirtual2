package org.lojavirtual.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Cliente;
import org.lojavirtual.repository.Clienterepository;
import org.lojavirtual.service.ClienteService;
import org.lojavirtual.util.FacesUtil;
@Named
@ViewScoped
public class Listaclientecontroler implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes ;
	@Inject
	private ClienteService clienteservico;
	@Inject
	private Clienterepository repositoryyc;
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void excluircliente2(Cliente cliente) {
		 this.cliente = cliente;
		 clienteservico.exluircliente(cliente);
		 FacesUtil.addInfoMessage("Cliente Excluido Com Sucesso");
	}
	
	public void consultarcliente() {
		clientes = this.repositoryyc.todos();
		
	}

    
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	public void pesquisarcliente() {
		this.clientes  = this.repositoryyc.porNomeSemelhante(nome);
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
   
}
