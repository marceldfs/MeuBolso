package mz.co.cedsif.meubolso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		this.manager.close();

	}

	public Ganho buscarPorId(Long id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		this.manager = factory.createEntityManager();

		Query query = manager.createQuery("select g from Ganho as g " + "where g.id=:paramId");
		query.setParameter("paramId", id);

		Ganho ganho = (Ganho) query.getSingleResult();
		this.manager.close();

		return ganho;
	}

	public List<Ganho> getLista() {


	
		ArrayList<Ganho> ganhos = new ArrayList<Ganho>();

		Query query = manager.createQuery("select g from Ganho as g");
		List<Ganho> ganhosDB = query.getResultList();

		if (ganhosDB != null) {
			for (Ganho ganho : ganhosDB) {
				ganhos.add(ganho);
			}
		}
		manager.close();
		return ganhos;
	}

}
