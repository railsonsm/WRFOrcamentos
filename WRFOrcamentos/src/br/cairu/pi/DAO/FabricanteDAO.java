package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.entidade.Fabricante;

public class FabricanteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();

	
	public Fabricante buscarFabricPorId(Integer idFabricante) {
        return manager.createQuery("select f from Fabricante f where f.idFabricante = :idFabricante", Fabricante.class).
        setParameter("idFabricante", idFabricante).getSingleResult();

	}

	public Fabricante salvar(Fabricante f) {
		manager.getTransaction().begin();
		manager.persist(f);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
	

	public Fabricante editar(Fabricante f) {
		manager.getTransaction().begin();
		manager.merge(f);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
	

	public Fabricante excluir(Integer idSelecionado) {
		Fabricante fabricanteSelecionado = manager.find(Fabricante.class, idSelecionado);
		manager.getTransaction().begin();
		manager.persist(fabricanteSelecionado);
		manager.getTransaction().commit();
		manager.close();
		return null;
	}
}
