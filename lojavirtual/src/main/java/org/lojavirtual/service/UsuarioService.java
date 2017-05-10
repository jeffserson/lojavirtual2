package org.lojavirtual.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Usuariorepository;

public class UsuarioService {

	private static final long serialVersionUID = 1L;
	@Inject
	private Usuariorepository usuariorepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario)
	{
		Usuario usuarioExistente = usuariorepository.porid(usuario.getId());
		
		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Usuario já cadastrado!!!.");
		}
		
		return usuariorepository.guardar(usuario);
	}
	
	@Transactional
	public void exluirusuario(Usuario usuario)
	{
		usuario = usuariorepository.porid(usuario.getId());
		usuariorepository.excluirusuario(usuario);
	}
	
}
