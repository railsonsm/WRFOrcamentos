package br.cairu.pi.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.cairu.pi.model.Usuario;
import br.cairu.pi.util.JPAUtil;

public class UsuarioDAO {
	
	EntityManager manager = new JPAUtil().getEntityManager();

	public boolean existe(Usuario usuario) {
		TypedQuery<Usuario> query =  manager.createQuery("select u from Usuario u where "
				+ "u.login = :pLogin and u.senha = :pSenha", Usuario.class);
				query.setParameter("pLogin", usuario.getLogin());
				query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado = query.getSingleResult();
		}catch (NoResultException e) {
			return false;
		}
		manager.close();
		return true;
	}
}
