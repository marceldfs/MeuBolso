package mz.co.cedsif.meu.bolso.acceptance.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Page {

	protected static final String BASE_URL = "http://localhost:8080";
	protected final WebDriver driver;
	

	public Page() {
		this.driver = new FirefoxDriver();
	}

	public void abrePaginaInicial() {
		driver.get(BASE_URL+Propriedades.PROJECTURL);
	}
	
	public void fecharPagina() {
		driver.close();
	}
	
	
}