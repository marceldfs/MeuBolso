package mz.co.cedsif.meu.bolso.acceptance.pageobject;

import org.openqa.selenium.By;

public class InicialPage extends Page {

	public InicialPage() {
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

}