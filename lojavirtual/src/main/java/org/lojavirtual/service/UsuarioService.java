package org.lojavirtual.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.lojavirtual.Produto;
import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Usuariorepository;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Usuariorepository usuariorepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario produtoExistente = usuariorepository.poremail(usuario.getEmail());
		
		if (produtoExistente != null && !produtoExistente.equals(usuario)) {
			throw new NegocioException("Já existe um produto com o CODIGO informado.");
		}
		
		return usuariorepository.guardar(usuario);
	}
	
	@Transactional
	public void exluirusuario(Usuario usuario) {
		usuario = usuariorepository.porid(usuario.getId());
		usuariorepository.excluirusuario(usuario);
	}
	
}
