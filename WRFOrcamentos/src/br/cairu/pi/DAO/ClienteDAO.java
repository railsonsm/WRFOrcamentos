package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.cairu.pi.entidade.Cliente;

public class ClienteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default"); 
	EntityManager manager = factory.createEntityManager();
	
	public Cliente salvar(Cliente c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		return null;
	}
		
}
