package mz.co.cedsif.meubolso.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import mz.co.cedsif.meubolso.model.Gasto;
import mz.co.cedsif.meubolso.test.builder.GastoBuilder;

/**
 * Classe de teste para o GASTO DAO
 * 
 *
 */
public class GastoDAOTest 
{
	
	@Test
	public void deveInserirGasto() {

		
		Gasto gasto = new GastoBuilder().comData(new Date()).comDescriao("ALMOCO").comValor(500).buildGasto();
		
		new GastoDAO().inserir(gasto);	

		assertNotNull(gasto.getId());
	}
	
	
	
}
