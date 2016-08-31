package mz.co.cedsif.meubolso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import mz.co.cedsif.meu.bolso.acceptance.pageobject.InicialPage;
import mz.co.cedsif.meu.bolso.acceptance.pageobject.Page;
import mz.co.cedsif.meu.bolso.acceptance.pageobject.Propriedades;

public class TesteTelaInicial {

	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	private static InicialPage navegador;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		Page navegador = new Page(browser);
	}

	@Test
	public void TestarNrButtoes() throws Exception {
		System.out.println("1");
		navegador.abrePaginaInicial();
		System.out.println("3");
		assertEquals(2, navegador.contaBotoes());

	}

	@Test
	public void TestarNGastoExiste() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(true, navegador.existeBotão(Propriedades.btGasto));
	}

	@Test
	public void TestarNGanhoExiste() throws Exception {
		navegador.abrePaginaInicial();
		assertEquals(true, navegador.existeBotão(Propriedades.btGanho));
	}

	@AfterClass
	public static void teardown() {
		navegador.fecharPagina();
	}
}
