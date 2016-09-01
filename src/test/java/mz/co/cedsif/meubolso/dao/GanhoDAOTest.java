package mz.co.cedsif.meubolso.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.TipoGanho;
import mz.co.cedsif.meubolso.test.builder.GanhoBuilder;

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
	
	@Test(expected=ConstraintViolationException.class)
	public void naoDeveInserirGanhoComDescricaoVazia()
	{
		Ganho ganhoSemValor = new GanhoBuilder().comDescriao(null).comData(new Date()).comTipo(TipoGanho.FIXO).comValor(2000).buildGanho();
		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganhoSemValor);
		Assert.assertNull(ganhoSemValor.getId());
	}
	
	
	@Test
	public void deveEncontrarGanho() {

		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;
		Ganho ganho = new Ganho(data, descricao, TipoGanho.FIXO, valor);

		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganho);

		Ganho ganhoBD = ganhoDAO.buscarPorId(ganho.getId());

		Assert.assertEquals(ganho.getDescricao(), ganhoBD.getDescricao());
	}

	@Test
	public void deveRetornarTamanhoDaLista() {

		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;
		Ganho ganho1 = new Ganho(data, descricao, TipoGanho.FIXO, valor);
		Ganho ganho2 = new Ganho(data, descricao, TipoGanho.FIXO, valor);

		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganho1);
		ganhoDAO.inserir(ganho2);

		ganhoDAO.getLista();

		Assert.assertEquals(2, ganhoDAO.getLista().size());
	}

}
