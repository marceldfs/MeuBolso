package mz.co.cedsif.meubolso.acceptance.pageobject;

import org.openqa.selenium.By;

public class InicialPage extends Page {

	public InicialPage() {
		super();
	}

	public int contaBotoes() {
		return this.driver.findElements(By.cssSelector("li")).size();
	}

	public Boolean existeLink(String btName) {
		if (this.driver.findElement(By.linkText(btName)) != null)
			return true;
		return false;

	}
	public Boolean existeBotao(String Name) {
		if (this.driver.findElement(By.name(Name)) != null)
			return true;
		return false;

	}


}