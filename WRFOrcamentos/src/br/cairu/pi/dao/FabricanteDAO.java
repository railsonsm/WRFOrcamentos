package br.cairu.pi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.model.Fabricante;
import br.cairu.pi.util.JPAUtil;

public class FabricanteDAO extends GenericDAO<Fabricante> {
	public FabricanteDAO() {
		super(Fabricante.class);
		// TODO Auto-generated constructor stub
	}

	
	public Fabricante buscarFabricPorId(Integer idFabricante) {
        return getSessao().createQuery("select f from Fabricante f where f.idFabricante = :idFabricante", Fabricante.class).
        setParameter("idFabricante", idFabricante).getSingleResult();

	}

	public List<Fabricante> porNomeSemelhante(String nome) {
		return getSessao().createQuery("from Fabricante where nome like :nome", Fabricante.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
}
