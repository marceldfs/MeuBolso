package mz.co.cedsif.meubolso.jpasetup;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.TipoMovimentos;

public class AdicionarGanho {

	public static void main(String[] args) {

		Date data = new Date();
		Ganho ganho = new Ganho(data, "Salario", TipoMovimentos.FIXO, 40.0);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(ganho);
		manager.getTransaction().commit();
		manager.close();

	}

}
