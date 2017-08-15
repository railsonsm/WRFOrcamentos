package ba.cairu.pi.DAO;

import org.hibernate.Session;

import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.util.HibernateUtil;

public class FabricanteDAO {
	final Session session = HibernateUtil.getHibernateSession();
	
	public Fabricante salvar(Fabricante f) {
		session.beginTransaction();
		session.save(f);
		session.getTransaction().commit();
		return null;
	}
}
