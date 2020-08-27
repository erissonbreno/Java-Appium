package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.AbasPage;
import br.ce.erissonbreno.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();

	@Test
	public void deveInteragirComAbas() {
		// ACESSAR MENU ABAS
		menu.acessarAbas();

		// VERIFICAR QUE ESTÁ NA ABA 1
		Assert.assertTrue(page.isAba1());

		// ACESSAR ABA 2
		page.clicarAba2();

		// VERIFICAR QUE ESTÁ NA ABA 2
		Assert.assertTrue(page.isAba2());
	}
}
