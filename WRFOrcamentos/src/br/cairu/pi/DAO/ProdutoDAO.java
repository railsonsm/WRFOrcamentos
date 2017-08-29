package br.cairu.pi.DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.cairu.pi.entidade.Produto;

public class ProdutoDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();
	
	
	/*public Fabricante busca(Integer idFabricante) {
        TypedQuery<Fabricante> query = this.session.createQuery("select f from Fabricante f where f.idFabricante = :idFabricante", Fabricante.class);
        query.setParameter("idFabricante", idFabricante);

        try{
            return query.getSingleResult();
        }catch(NoResultException e){
            e.printStackTrace();
            return null;
        }

    }*/
	
	public Produto salvar(Produto p) {
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		return null;
	}
}
