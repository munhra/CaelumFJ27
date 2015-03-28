package br.com.caelum.estoque.dao;

import java.util.List;

import br.com.caelum.estoque.Usuario;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository("usuarioDAO")
public class UsuarioHibernateDAO implements UsuarioDAO{

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public UsuarioHibernateDAO(SessionFactory factory){
		hibernateTemplate = new HibernateTemplate(factory);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		List usuarios = hibernateTemplate.find("from Usuario where login = ?",username);
		
		if	(!usuarios.isEmpty()){
			return (Usuario) usuarios.get(0);
		}else{
			return null;
		}
		
		
	}

	
	
	
}
