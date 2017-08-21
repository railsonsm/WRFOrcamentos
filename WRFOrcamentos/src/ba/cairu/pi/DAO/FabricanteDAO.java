package ba.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.criterion.Restrictions;

import br.cairu.pi.entidade.Fabricante;

public class FabricanteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();

	/*public Fabricante buscarFabricanteporId(Integer id) {
		
		return(Fabricante) session.createCriteria(Fabricante.class)
				.add(Restrictions.idEq(id)).uniqueResult();
	}*/
	
	public Fabricante salvar(Fabricante f) {
		manager.getTransaction().begin();
		manager.persist(f);
		manager.getTransaction().commit();
		return null;
	}
}
