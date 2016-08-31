package mz.co.cedsif.meubolso.acceptance.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mz.co.cedsif.meubolso.acceptance.properties.Propriedades;

public class Page {

	protected final WebDriver driver;

	public Page() {
		System.setProperty("webdriver.chrome.driver", Propriedades.chromeDriverLocation);
		this.driver = new ChromeDriver();
	}

	public void abrePaginaInicial() {
		driver.get(Propriedades.BASE_URL + Propriedades.PROJECTURL);
	}

	public void fecharPagina() {
		driver.close();
	}

}