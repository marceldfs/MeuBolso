package mz.co.cedsif.meubolso.acceptance.pageobject;

import org.openqa.selenium.By;

import mz.co.cedsif.meubolso.acceptance.properties.Propriedades;
import mz.co.cedsif.meubolso.model.Gasto;

public class GastoPage extends Page {
	public GastoPage() {
		super();
	}

	public void abrePaginaGasto() {
		this.abrePaginaInicial();
		this.driver.findElement(By.linkText(Propriedades.linkNovoGasto)).click();
	}

	public void preencherGasto(Gasto gasto) {
		this.driver.findElement(By.id(Propriedades.fieldDataID)).sendKeys(gasto.getData().toString());
		this.driver.findElement(By.name(Propriedades.fieldDescricaoName)).sendKeys(gasto.getDescricao());
		this.driver.findElement(By.name(Propriedades.fieldTipoName)).sendKeys(gasto.getTipo().FIXO.toString());
		this.driver.findElement(By.name(Propriedades.fieldValorName)).sendKeys(gasto.getValor().toString());
	}

	public void clicarCadastrar() {
		this.driver.findElement(By.name(Propriedades.btCadastrarName)).click();
	}

	public boolean verificarGasto(Gasto gasto) {

		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText()
				.equals(gasto.getData().toString()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText()
				.equals(gasto.getDescricao()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText()
				.equals(gasto.getTipo()))
			return false;
		if (!this.driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(4)")).getText()
				.equals(gasto.getValor().toString()))
			return false;
		return true;
	}
}
