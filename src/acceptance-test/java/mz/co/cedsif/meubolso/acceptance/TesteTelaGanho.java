package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meu.bolso.acceptance.pageobject.GanhoPage;
import mz.co.cedsif.meu.bolso.acceptance.pageobject.GastoPage;
import mz.co.cedsif.meubolso.model.Ganho;


public class TesteTelaGanho {

	private static GanhoPage navegador;

	@Before
	public void setUp() throws Exception {
		navegador = new GanhoPage();
	}

	@Test
	public void TestarCriargasto() throws Exception {
		Ganho ganho = new Ganho();
		navegador.abrePaginaGanho();
		navegador.preencherGanho(ganho);
		navegador.clicarCadastrar();

		assertEquals(true, navegador.verificarGanho(ganho));
	}

	@After
	public static void teardown() {
		navegador.fecharPagina();
	}
}
