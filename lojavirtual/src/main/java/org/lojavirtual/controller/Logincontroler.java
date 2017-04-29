package org.lojavirtual.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.lojavirtual.Login;
import org.lojavirtual.service.Loginservice;

@Named
@javax.faces.view.ViewScoped
public class Logincontroler implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Login login;
	@Inject
	private Loginservice service;
	
	public void logar(Login login){
		this.service.login(login);
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
