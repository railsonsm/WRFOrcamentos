package br.cairu.pi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.model.Cliente;
import br.cairu.pi.util.JPAUtil;

public class ClienteDAO extends GenericDAO<Cliente>{
	public ClienteDAO(Class<Cliente> classe) {
		super(Cliente.class);
	}
	
	public List<Cliente> porNomeSemelhante(String nome) {
		return getSessao().createQuery("from Cliente where nome like :nome", Cliente.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
}
