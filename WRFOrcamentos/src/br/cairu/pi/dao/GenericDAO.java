package br.cairu.pi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.sun.jndi.ldap.ManageReferralControl;

import br.cairu.pi.util.JPAUtil;

public abstract class  GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void salvar(T t) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		manager.close();
	}

	public void excluir(T t) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.merge(t));
		manager.getTransaction().commit();
		manager.close();
	}

	public void editar(T t) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		manager.close();
	}

	public List<T> listaTodos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = manager.createQuery(query).getResultList();
		manager.close();
		return lista;
	}

	public T buscaPorId(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		T instancia = manager.find(classe, id);
		manager.close();
		return instancia;
	}

	public int contaTodos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		long result = (Long) manager.createQuery("select count(n) from livro n").getSingleResult();
		manager.close();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		EntityManager manager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = manager.createQuery(query).setFirstResult(firstResult)
		.setMaxResults(maxResults).getResultList();
		manager.close();
		return lista;
	}
	
	public EntityManager getSessao() {
		EntityManager manager = new JPAUtil().getEntityManager();
		return manager;
	}

}