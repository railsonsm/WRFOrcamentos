package br.cairu.pi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
		private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("default");
	
	public EntityManager getEntityManager() {
		EntityManager manager = factory.createEntityManager();
		System.out.println("persistiu");
		return manager;	
	}

	public void close(EntityManager manager) {
		manager.close();
	}

	
}
