package br.cairu.pi.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.entidade.SequenciaCliente;


public class SequenciaClienteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default"); 
	EntityManager manager = factory.createEntityManager();
	
	public SequenciaCliente buscaSequencia() {
		return manager.createQuery("select s from SequenciaCliente s", SequenciaCliente.class).getSingleResult();
	}
}
