package mz.co.cedsif.meubolso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;

public class GastoDAO {
	
	private EntityManager manager;
	

	public GastoDAO(EntityManager manager2) {
		// TODO Auto-generated constructor stub
	}


	public GastoDAO() {
		// TODO Auto-generated constructor stub
	}


	public void inserir(Gasto gasto) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gasto");
		this.manager = factory.createEntityManager();

		this.manager.getTransaction().begin();
		this.manager.persist(gasto);
		this.manager.getTransaction().commit();
		this.manager.close();
		
	}


	public Ganho buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
