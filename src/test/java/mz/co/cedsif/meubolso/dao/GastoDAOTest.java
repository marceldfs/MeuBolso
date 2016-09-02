package mz.co.cedsif.meubolso.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import mz.co.cedsif.meubolso.model.Gasto;

/**
 * Classe de teste para o GASTO DAO
 * 
 *
 */
public class GastoDAOTest 
{
	
	@Test
	public void deveInserirGasto() {

		Date data = new Date();
		String descricao = "ALMOCO";
		double valor = 500.0;
		
		Gasto gasto = new Gasto();
		gasto.setData(data);
		gasto.setDescricao(descricao);
		gasto.setValor(valor);
		
		new GastoDAO().inserir(gasto);	

		assertNotNull(gasto.getId());
	}
	
	
	
}
