package br.cairu.pi.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.model.Produto;

public class ProdutoDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();

	public Produto mostraProdutoPorId(Integer idProduto) {
        return manager.createQuery("select p from Produto p  where p.idProduto = :idProduto", Produto.class).
        setParameter("idProduto", idProduto).getSingleResult();

	}
	
	public Produto salvar(Produto p) {
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
}
