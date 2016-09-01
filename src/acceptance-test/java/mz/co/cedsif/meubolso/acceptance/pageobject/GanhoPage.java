package mz.co.cedsif.meubolso.acceptance.pageobject;

import org.openqa.selenium.By;

import mz.co.cedsif.meubolso.acceptance.properties.Propriedades;
import mz.co.cedsif.meubolso.model.Ganho;

public class GanhoPage extends Page {
	public GanhoPage() {
		super();
	}

	public void abrePaginaGanho() {
		this.abrePaginaInicial();
		this.driver.findElement(By.linkText(Propriedades.linkNovoGasto)).click();
	}

	public void preencherGanho(Ganho ganho) {
		this.driver.findElement(By.id(Propriedades.fieldDataID)).sendKeys(ganho.getData().toString());
		this.driver.findElement(By.name(Propriedades.fieldDescricaoName)).sendKeys(ganho.getDescricao());
		this.driver.findElement(By.name(Propriedades.fieldTipoName)).sendKeys(ganho.getTipo().toString());
		this.driver.findElement(By.name(Propriedades.fieldValorName)).sendKeys(ganho.getValor().toString());
	}

	public void clicarCadastrar() {
		this.driver.findElement(By.name(Propriedades.btCadastrarName)).click();
	}

	public boolean verificarGanho(Ganho ganho) {

		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText()
				.equals(ganho.getData().toString()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText()
				.equals(ganho.getDescricao()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText()
				.equals(ganho.getTipo()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(4)")).getText()
				.equals(ganho.getValor().toString()))
			return false;
		return true;
	}
}
