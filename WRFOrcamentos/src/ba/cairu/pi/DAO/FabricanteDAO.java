package ba.cairu.pi.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.util.HibernateUtil;

public class FabricanteDAO {
	final Session session = HibernateUtil.getHibernateSession();
	List<Fabricante> lista;
	
	public Fabricante buscarFabricanteporId(Integer id) {
		return(Fabricante) session.createCriteria(Fabricante.class)
				.add(Restrictions.idEq(id)).uniqueResult();
		
	}
	
	public Fabricante salvar(Fabricante f) {
		session.beginTransaction();
		session.save(f);
		session.getTransaction().commit();
		return null;
	}
}
