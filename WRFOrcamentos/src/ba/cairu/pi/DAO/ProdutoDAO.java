package ba.cairu.pi.DAO;

import org.hibernate.Session;

import br.cairu.pi.entidade.Produto;
import br.cairu.pi.util.HibernateUtil;

public class ProdutoDAO {
	final Session session = HibernateUtil.getHibernateSession();
	
	public Produto salvar(Produto p) {
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		return null;
	}
}
