package org.lojavirtual.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Grupo;
import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Gruporepository;
import org.lojavirtual.service.UsuarioService;
import org.lojavirtual.util.FacesUtil;


@Named
@ViewScoped
public class Usuariocontroler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Grupo> grupos ;
	@Inject
	private UsuarioService usuarioservice;
	@Inject
	private Gruporepository repository;
	public void preparausuario()
	{
		if(this.usuario == null)
			usuario = new Usuario();
	}
	
	 public void salvar(){
	    	this.usuario = usuarioservice.salvar(this.usuario);
	        FacesUtil.addInfoMessage("Usuario salvo com sucesso");	
	       
	    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGrupos() {
		return repository.findAll();
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
    
}
