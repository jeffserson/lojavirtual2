package org.lojavirtual.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lojavirtual.Login;

public class Loginrepository implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
    
	public void logar(Login cliente){
		
		
		
			
}

}
