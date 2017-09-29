package br.cairu.pi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory manager = Persistence.createEntityManagerFactory("default");
	
	public static EntityManager createEntityManager(){
		return manager.createEntityManager();
	}

	
}
