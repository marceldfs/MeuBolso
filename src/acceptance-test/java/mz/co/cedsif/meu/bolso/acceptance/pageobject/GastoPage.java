package mz.co.cedsif.meu.bolso.acceptance.pageobject;

import org.openqa.selenium.By;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;

public class GastoPage extends Page {
	public GastoPage() {
		super();
	}

	public int contaBotoes() {
		return this.driver.findElements(By.cssSelector("")).size();
	}

	public Boolean existeBotão(String btName) {
		if (this.driver.findElements(By.linkText(btName)) != null)
			return true;
		return false;

	}

	public void abrePaginaGasto() {
		this.abrePaginaInicial();
		this.driver.findElement(By.linkText(Propriedades.linkNovoGasto)).click();
	}

	public void preencherGasto(Gasto gasto) {
		this.driver.findElement(By.name(Propriedades.fieldData)).sendKeys(gasto.getData().toString());
		this.driver.findElement(By.name(Propriedades.fieldOque)).sendKeys(gasto.getDescrição());
		this.driver.findElement(By.name(Propriedades.fieldTipo)).sendKeys(gasto.getTipo());
		this.driver.findElement(By.name(Propriedades.fieldValor)).sendKeys(gasto.getValor().toString());
	}

	public void clicarCadastrar() {
		this.driver.findElement(By.name(Propriedades.btCadastrar)).click();
	}

	public boolean verificarGasto(Gasto gasto) {
		boolean resposta = false;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(1)")).getText().equals(gasto.getData().toString()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(2)")).getText().equals(gasto.getDescrição()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(3)")).getText().equals(gasto.getTipo()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(4)")).getText().equals(gasto.getValor().toString()))

			resposta = true;
		return resposta;
	}
}
