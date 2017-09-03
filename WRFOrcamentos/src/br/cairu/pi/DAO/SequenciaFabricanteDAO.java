package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.entidade.SequenciaFabricante;

public class SequenciaFabricanteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	EntityManager manager = factory.createEntityManager();
	
	public SequenciaFabricante buscaSequencia() {
		return manager.createQuery("select sf from SequenciaFabricante sf", SequenciaFabricante.class).getSingleResult();
	}
}
