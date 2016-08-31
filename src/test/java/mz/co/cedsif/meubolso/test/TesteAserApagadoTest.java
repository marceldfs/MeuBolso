package mz.co.cedsif.meubolso.test;

import org.junit.Assert;
import org.junit.Test;

import mz.co.cedsif.meubolso.dao.GanhoDAO;

//teste
public class TesteAserApagadoTest {

	@Test
	public void deveInserirGanho() {

		Assert.assertTrue(new GanhoDAO().inserir());

	}

}
