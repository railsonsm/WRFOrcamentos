package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.entidade.SequenciaProduto;

public class SequenciaProdutoDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();
	
	public SequenciaProduto buscaSequencia() {
		return manager.createQuery("select sp from SequenciaProduto sp", SequenciaProduto.class).getSingleResult();
	}
}
