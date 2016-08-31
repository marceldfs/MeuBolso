package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import mz.co.cedsif.meubolso.acceptance.pageobject.InicialPage;
import mz.co.cedsif.meubolso.acceptance.pageobject.Page;
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
		assertEquals(true, navegador.existeBotão(Propriedades.linkNovoGasto));
	}

	@Test
	public void TestarNGanhoExiste() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(true, navegador.existeBotão(Propriedades.linkNovoGanho));
	}

	@After
	public static void teardown() {
		navegador.fecharPagina();
	}
}
