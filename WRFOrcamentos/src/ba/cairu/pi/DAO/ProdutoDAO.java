package ba.cairu.pi.DAO;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.entidade.Produto;
import br.cairu.pi.util.HibernateUtil;

public class ProdutoDAO {
	final Session session = HibernateUtil.getHibernateSession();
	
	
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
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		return null;
	}
}
