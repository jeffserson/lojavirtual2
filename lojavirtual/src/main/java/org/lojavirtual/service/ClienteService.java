package org.lojavirtual.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.lojavirtual.Cliente;
import org.lojavirtual.repository.Clienterepository;

public class ClienteService implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Inject
	private Clienterepository cliente1  ;
	@Transactional
	public void salvar(Cliente cliente){
		this.cliente1.guardar(cliente);
	}
	@Transactional
	public void exluircliente(Cliente cliente) {
		cliente = cliente1.porid(cliente.getId());
		cliente1.excluircliente1(cliente);
	}
}
