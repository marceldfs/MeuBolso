package mz.co.cedsif.meubolso.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	
}
