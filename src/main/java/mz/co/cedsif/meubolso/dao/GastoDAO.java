package mz.co.cedsif.meubolso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mz.co.cedsif.meubolso.model.Gasto;

public class GastoDAO {
	
	private EntityManager manager;
	

	public void inserir(Gasto gasto) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gasto");
		this.manager = factory.createEntityManager();

		this.manager.getTransaction().begin();
		this.manager.persist(gasto);
		this.manager.getTransaction().commit();
		this.manager.close();
		
	}

}
