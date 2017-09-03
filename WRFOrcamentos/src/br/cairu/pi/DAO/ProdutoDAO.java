package br.cairu.pi.DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.cairu.pi.entidade.Produto;

public class ProdutoDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();

	public Produto salvar(Produto p) {
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		return null;
	}
}
