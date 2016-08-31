package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meubolso.acceptance.pageobject.GanhoPage;
import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.test.builder.GanhoBuilder;

public class TesteTelaGanho {

	private static GanhoPage navegador;

	@Before
	public void setUp() throws Exception {
		navegador = new GanhoPage();
	}

	@Test
	public void TestarCriargasto() throws Exception {
		Ganho ganho = new GanhoBuilder().cria();
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
