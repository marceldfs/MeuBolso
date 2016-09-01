package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mz.co.cedsif.meubolso.acceptance.pageobject.InicialPage;
import mz.co.cedsif.meubolso.acceptance.properties.Propriedades;

public class TesteTelaInicial {

	private static InicialPage navegador;

	@Before
	public void setUp() throws Exception {
		navegador = new InicialPage();
	}

	@Test
	public void TestarNrButtoes() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(2, navegador.contaBotoes());
	}

	@Test
	public void TestarNGastoExiste() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(true, navegador.existeBotao(Propriedades.linkNovoGasto));
	}

	@Test
	public void TestarNGanhoExiste() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(true, navegador.existeBotao(Propriedades.linkNovoGanho));
	}

	@After
	public void teardown() {
		navegador.fecharPagina();
	}
}
