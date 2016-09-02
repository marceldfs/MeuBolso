package mz.co.cedsif.meubolso.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

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

		assertNotNull(ganho.getId());
	}

	@Test(expected = ConstraintViolationException.class)
	public void naoDeveInserirGanhoComDescricaoVazia() {
		Ganho ganhoSemDescricao = new GanhoBuilder().comDescriao(null).comData(new Date()).comTipo(TipoGanho.FIXO)
				.comValor(2000).buildGanho();
		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganhoSemDescricao);
	}

	@Test(expected = ConstraintViolationException.class)
	public void naoDeveInserirGanhoComValorZero() {
		Ganho ganhoZero = new GanhoBuilder().comDescriao("Salario").comData(new Date()).comTipo(TipoGanho.FIXO)
				.comValor(0).buildGanho();
		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganhoZero);
	}

	@Test(expected = ConstraintViolationException.class)
	public void naoDeveInserirGanhoComValorNegativo() {
		Ganho ganhoZero = new GanhoBuilder().comDescriao("Salario").comData(new Date()).comTipo(TipoGanho.FIXO)
				.comValor(-1).buildGanho();
		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganhoZero);
	}

	@Test(expected = ConstraintViolationException.class)
	public void naoDeveInserirGanhoComTipoVazio() {
		Ganho ganhoZero = new GanhoBuilder().comDescriao("Salario").comData(new Date()).comTipo(null).comValor(200)
				.buildGanho();
		GanhoDAO ganhoDAO = new GanhoDAO(this.manager);
		ganhoDAO.inserir(ganhoZero);
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

		assertEquals(ganho.getDescricao(), ganhoBD.getDescricao());
	}

	@Test
	public void deveRetornar2ComoTamanhoDaLista() {

		
		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;
		Ganho ganho1 = new Ganho(data, descricao, TipoGanho.FIXO, valor);
		Ganho ganho2 = new Ganho(data, descricao, TipoGanho.FIXO, valor);


//		GanhoDAO ganhoDAOFalso = mock(GanhoDAO.class);
//		when(ganhoDAOFalso.getLista()).thenReturn(Arrays.asList(ganho1, ganho2));
		
		Query query = mock(Query.class);
        EntityManager managerFalso = mock(EntityManager.class);
		when(managerFalso.createQuery("select g from Ganho as g")).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(ganho1, ganho2));
		
		GanhoDAO ganhoDao = new GanhoDAO(managerFalso);

//        Assert.assertEquals(2, ganhoDAOFalso.getLista().size());
		 assertEquals(2, ganhoDao.getLista().size());

	}

	@Test
	public void deveRetornarUmaListaVazia() {

		GanhoDAO ganhoDAOFalso = mock(GanhoDAO.class);
		when(ganhoDAOFalso.getLista()).thenReturn(Arrays.asList());

		assertTrue(ganhoDAOFalso.getLista().isEmpty());

	}

}
