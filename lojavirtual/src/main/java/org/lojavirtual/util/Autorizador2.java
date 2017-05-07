package org.lojavirtual.util;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NamedQuery;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lojavirtual.Grupo;
import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Usuariorepository;

public class Autorizador2 extends SimpleAccountRealm {
    
	private Usuariorepository usuariorepository;
	
	private Logger logger;
	
	public Autorizador2() {
		super();
		this.logger = Logger.getLogger(Autorizador2.class.getName());
		
			
		}
	
	
	
	
	
	@Override
	   protected AuthenticationInfo doGetAuthenticationInfo(
	       AuthenticationToken token) throws AuthenticationException {
		// Identify account to log to
		 
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		 
		String email = userPassToken.getUsername();
		
		if (email == null) {
		 
		logger.warning("Username is null.");
		 
		return null;
		 
		}
		 
		 
		 
		 
		 
		this.usuariorepository = getUsuariorepository();
		Usuario user = this.usuariorepository.logar(email);
		if (user == null) {
			logger.warning("No account found for user [" + email + "]");
			throw new IncorrectCredentialsException();
			}
		
		
		 if(user != null) {
	        	return new SimpleAuthenticationInfo(email,user.getSenha(),getName());  
	        }
	        throw new AuthenticationException() ;
		
	   }
	 
	   @Override
	   protected AuthorizationInfo doGetAuthorizationInfo(
	        PrincipalCollection principals) {
		 //null usernames are invalid
		   
		   if (principals == null) {
		    
		 
		    
		   }
		    
		    
		  
		   String email = (String) getAvailablePrincipal(principals);
		 
		   Set<String> roleNames = new HashSet<>();
		   roleNames.add(this.usuariorepository.logar(email).getGrupo().getNome());
		   AuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		    
		   /**
		    
		   * If you want to do Permission Based authorization, you can grab the Permissions List
		   associated to your user:
		    
		   * Set<String> permissions = new HashSet<>();
		    
		   *
		   permissions.add(this.userService.findByUsername(username).getRole().getPermissions());
		    
		   * ((SimpleAuthorizationInfo)info).setStringPermissions(permissions);
		    
		   */
		  
		   return info;
	   }
	   public Usuariorepository getUsuariorepository() {
			 Properties props = new Properties();
		        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		        try {
		            InitialContext ctx = new InitialContext(props);
		            Usuariorepository usuariorepository = (Usuariorepository) ctx.lookup("java:global/lojavirtual/Usuariorepository");
		            return usuariorepository;
		        } catch(NamingException e) { 
		            throw new RuntimeException(e.getMessage());
		        }}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		 return this.getClass().getSimpleName();
	}



	@Override
	public boolean supports(AuthenticationToken arg0) {
		// TODO Auto-generated method stub
		return true;
	}
}
