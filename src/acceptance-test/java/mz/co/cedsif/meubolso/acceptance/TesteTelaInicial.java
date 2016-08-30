package mz.co.cedsif.meubolso.acceptance;

package mz.co.cedsif.meubolso.acceptance;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import mz.co.cedsif.meu.bolso.acceptance.pageobject.Page;

public class TesteTelaInicial {

	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	private static Page navegador;
	

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		Page navegador = new Page(browser);
	}

	@Test
	public void TestarNrButtoes() throws Exception {}
	@Test
	public void TestarExisteTabela() throws Exception {}
	@AfterClass
	public static void teardown() {
		browser.close();
	}
}
