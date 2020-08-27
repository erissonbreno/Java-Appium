package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.CliquesPage;
import br.ce.erissonbreno.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void deveAcessarMenuCliques() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		// REALIZAR CLIQUE LONGO
		page.cliqueLongo("Clique Longo");

		// VERIFICAR CAMPO
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
}
