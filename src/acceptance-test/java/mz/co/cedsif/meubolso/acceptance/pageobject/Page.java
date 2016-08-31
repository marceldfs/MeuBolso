package mz.co.cedsif.meubolso.acceptance.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import mz.co.cedsif.meubolso.acceptance.properties.Propriedades;

public class Page {

	protected final WebDriver driver;

	public Page() {
		this.driver = new FirefoxDriver();
	}

	public void abrePaginaInicial() {
		driver.get(Propriedades.BASE_URL + Propriedades.PROJECTURL);
	}

	public void fecharPagina() {
		driver.close();
	}

}