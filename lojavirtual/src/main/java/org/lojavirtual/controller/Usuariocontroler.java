package org.lojavirtual.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Usuario;
import org.lojavirtual.service.UsuarioService;
import org.lojavirtual.util.FacesUtil;


@Named
@ViewScoped
public class Usuariocontroler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	@Inject
	private UsuarioService usuarioservice;
	
	public void prepara()
	{
		if(this.usuario == null)
			usuario = new Usuario();
	}
	
	public String salvar()
	{
		this.usuario = usuarioservice.salvar(usuario);
		FacesUtil.addInfoMessage("Usuario salvo com sucesso");	
        return "/usuario/UsuariosCadastrados?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
