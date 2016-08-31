package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import mz.co.cedsif.meu.bolso.acceptance.pageobject.GastoPage;
import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;

public class TesteTelaGasto {

	private static GastoPage navegador;

	@Before
	public void setUp() throws Exception {
		navegador = new GastoPage();
	}

	@Test
	public void TestarCriargasto() throws Exception {
		Gasto gasto = new Gasto();
		navegador.abrePaginaGasto();
		navegador.preencherGasto(gasto);
		navegador.clicarCadastrar();

		assertEquals(true, navegador.verificarGasto(gasto));
	}

	@After
	public static void teardown() {
		navegador.fecharPagina();
	}
}
