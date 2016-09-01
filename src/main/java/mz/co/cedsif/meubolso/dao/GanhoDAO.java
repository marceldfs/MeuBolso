package mz.co.cedsif.meubolso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mz.co.cedsif.meubolso.model.Ganho;

public class GanhoDAO {

	private EntityManager manager;

	public GanhoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void inserir(Ganho ganho) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		this.manager = factory.createEntityManager();

		this.manager.getTransaction().begin();
		this.manager.persist(ganho);
		this.manager.getTransaction().commit();
	}

	public Ganho buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
