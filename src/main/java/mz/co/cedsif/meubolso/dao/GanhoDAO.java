package mz.co.cedsif.meubolso.dao;

public class GanhoDAO {

	public void inserir() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(ganho);
		manager.close();
	}

}
