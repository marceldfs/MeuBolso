package mz.co.cedsif.meu.bolso.acceptance.pageobject;

import org.openqa.selenium.By;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;

public class GanhoPage extends Page {
	public GanhoPage() {
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

	public void abrePaginaGanho() {
		this.abrePaginaInicial();
		this.driver.findElement(By.linkText(Propriedades.linkNovoGasto)).click();
	}

	public void preencherGanho(Ganho ganho) {
		this.driver.findElement(By.name(Propriedades.fieldData)).sendKeys(ganho.getData().toString());
		this.driver.findElement(By.name(Propriedades.fieldOque)).sendKeys(ganho.getDescrição());
		this.driver.findElement(By.name(Propriedades.fieldTipo)).sendKeys(ganho.getTipo());
		this.driver.findElement(By.name(Propriedades.fieldValor)).sendKeys(ganho.getValor().toString());
	}

	public void clicarCadastrar() {
		this.driver.findElement(By.name(Propriedades.btCadastrar)).click();
	}

	public boolean verificarGanho(Ganho ganho) {
		boolean resposta = false;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(1)")).getText().equals(ganho.getData().toString()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(2)")).getText().equals(ganho.getDescrição()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(3)")).getText().equals(ganho.getTipo()))

			resposta = true;
		if (this.driver.findElement(By.cssSelector("tr:nth-child(4)")).getText().equals(ganho.getValor().toString()))

			resposta = true;
		return resposta;
	}
}
