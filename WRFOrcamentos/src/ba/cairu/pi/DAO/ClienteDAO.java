package ba.cairu.pi.DAO;

import org.hibernate.Session;

import br.cairu.pi.entidade.Cliente;
import br.cairu.pi.util.HibernateUtil;

public class ClienteDAO {
	final Session session = HibernateUtil.getHibernateSession();
	
	public Cliente salvar(Cliente c) {
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		return null;
	}
		
}
