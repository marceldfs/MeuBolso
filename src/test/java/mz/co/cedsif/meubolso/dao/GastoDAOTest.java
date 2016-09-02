package mz.co.cedsif.meubolso.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;
import mz.co.cedsif.meubolso.model.TipoMovimentos;
import mz.co.cedsif.meubolso.test.builder.GastoBuilder;

/**
 * Classe de teste para o GASTO DAO
 * 
 *
 */
public class GastoDAOTest 
{
	private EntityManager manager;
	private EntityManagerFactory factory;

	@Before
	public void inicializa() {
		this.factory = Persistence.createEntityManagerFactory("gasto");
		this.manager = this.factory.createEntityManager();
	}
	
	@Test
	public void deveInserirGasto() {
		Gasto gasto = new GastoBuilder().comData(new Date()).comDescriao("ALMOCO").comValor(500).buildGasto();
		new GastoDAO().inserir(gasto);	
		assertNotNull(gasto.getId());
	}
	
	@Test
	public void deveEncontrarGasto() {

		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;
		Gasto gasto = new Gasto(data, descricao, TipoMovimentos.FIXO, valor);

		GastoDAO ganhoDAO = new GastoDAO(this.manager);
		ganhoDAO.inserir(gasto);

		Gasto gastoBD = ganhoDAO.buscarPorId(gasto.getId());

		assertEquals(gasto.getDescricao(), gastoBD.getDescricao());
	}

	@Test
	public void deveRetornar2ComoTamanhoDaLista() {

		Date data = new Date();
		String descricao = "Salario";
		double valor = 3000.0;
		Gasto gasto1 = new Gasto(data, descricao, TipoMovimentos.FIXO, valor);
		Gasto gasto2 = new Gasto(data, descricao, TipoMovimentos.FIXO, valor);
		
		Query query = mock(Query.class);
        EntityManager managerFalso = mock(EntityManager.class);
		when(managerFalso.createQuery("select g from Gasto as g")).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(gasto1, gasto2));
		GastoDAO gastoDao = new GastoDAO(managerFalso);
		assertEquals(2, gastoDao.getLista().size());
	}

	
}
