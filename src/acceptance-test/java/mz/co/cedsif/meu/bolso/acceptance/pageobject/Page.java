package mz.co.cedsif.meu.bolso.acceptance.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;
	

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void abrePaginaInicial() {
		driver.get(BASE_URL+Propriedades.PROJECTURL);
	}
	
	public void fecharPagina() {
		driver.close();
	}
	public void contarButoes() {
	

	}
	
}