package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.cairu.pi.entidade.Cliente;
import br.cairu.pi.entidade.Fabricante;

public class ClienteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default"); 
	EntityManager manager = factory.createEntityManager();
	
	public Cliente salvar(Cliente c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
	
	public Cliente excluir(Integer idSelecionado) {
		Cliente clienteSelecionado = manager.find(Cliente.class, idSelecionado);
		manager.getTransaction().begin();
		manager.remove(clienteSelecionado);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
	
	public Cliente editar(Cliente c) {
		manager.getTransaction().begin();
		manager.merge(c);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
	
	public Cliente buscarCliPorId(Integer idCliente) {
        return manager.createQuery("select c from Cliente c where c.idCliente = :idCliente", Cliente.class).
        setParameter("idCliente", idCliente).getSingleResult();

	}
}
