package mz.co.cedsif.meubolso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;

public class GastoDAO {
	
	private EntityManager manager;
	

	public GastoDAO(EntityManager manager) {
		this.manager =  manager;
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


	public Gasto buscarPorId(Long id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		this.manager = factory.createEntityManager();

		Query query = manager.createQuery("select g from Gasto as g " + "where g.id=:paramId");
		query.setParameter("paramId", id);

		Gasto gasto = (Gasto) query.getSingleResult();
		this.manager.close();

		return gasto;
		
	}


	public List<Gasto> getLista() {
		List<Gasto> gastos = new ArrayList<Gasto>();

		Query query = manager.createQuery("select g from Gasto as g");
		List<Gasto> gastoDB = query.getResultList();

		if (gastoDB != null) {
			for (Gasto gasto : gastoDB) {
				gastos.add(gasto);
			}
		}
		manager.close();
		return gastos;
	}

}
