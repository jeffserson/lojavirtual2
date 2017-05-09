package org.lojavirtual.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.xalan.xsltc.dom.ExtendedSAX;
import org.lojavirtual.Grupo;
import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Usuariorepository;
import org.lojavirtual.util.FacesUtil;

@Named
@SessionScoped
public class Logincontroler implements Serializable   {
    
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario  = new Usuario();
	 @Inject
	 private Subject user;
     @Inject
     private FacesContext context;
     @Inject
	 private Usuariorepository usuariorepository;
     private List<Grupo> grupos; 
     
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		 try { 
		        UsernamePasswordToken token = new UsernamePasswordToken(usuario.getEmail(), usuario.getSenha());
		        
		        user.login(token);
               
		        return "/produto/ProdutosCadastrados.xhtml?faces-redirect=true";
		    } catch(AuthenticationException e) {
		                FacesUtil.addErrorMessage("Usuario nao encontrado");
		        }
		    return null;
		
		
	}
	
	public String desLogar() {
		return "index.xhtml?faces-redirect=true";
	}
}
