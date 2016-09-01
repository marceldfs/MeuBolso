package mz.co.cedsif.meubolso.jpasetup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarTabelas {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ganho");
		factory.close();

	}

}
