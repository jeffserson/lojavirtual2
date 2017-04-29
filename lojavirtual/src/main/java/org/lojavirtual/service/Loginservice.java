package org.lojavirtual.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.lojavirtual.Login;
import org.lojavirtual.repository.Loginrepository;

public class Loginservice implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Inject
	private Loginrepository loginrepository;
	
	@Transactional
	public void login(Login login){
		this.loginrepository.logar(login);
	}
	
}
