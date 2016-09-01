package mz.co.cedsif.meubolso.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.TipoGanho;

public class GanhoDAOTest {

	private EntityManager manager;
	private EntityManagerFactory factory;

	@Before
	public void inicializa() {
		this.factory = Persistence.createEntityManagerFactory("ganho");
		this.manager = this.factory.createEntityManager();
	}

	@Test
	public void deveInserirGanho() {

		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;

		Ganho ganho = new Ganho(data, descricao, TipoGanho.FIXO, valor);

		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganho);

		Assert.assertNotNull(ganho.getId());
	}

	@Test
	public void deveEncontrarGanho() {

		Date data = new Date();
		String descricao = "Dipesh";
		double valor = 3000.0;
		Ganho ganho = new Ganho(data, descricao, TipoGanho.FIXO, valor);

		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganho);

		Ganho ganhoBD = ganhoDAO.buscarPorId(ganho.getId());

		Assert.assertEquals(ganho.getDescri��o(), ganhoBD.getDescri��o());
	}

}
