package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.MenuPage;
import br.ce.erissonbreno.appium.page.SwipeListPage;

public class DesafioSwipeList extends BaseTest {
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveInteragirSwipeList() {
		
	// CLICAR SWIPE LIST
		menu.scrollDown();
		menu.acessarSwipeList();
	
	// OPCAO 1 PARA DIREITA
		page.swipeElementRight("Opção 1");		
	
	// CLICAR BOTAO OP1+
		page.clicarBotaoMais();
	
	// VERIFICAR OP1+
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
	
	// OPCAO 4 PARA DIREITA
		page.swipeElementRight("Opção 4");
	
	// CLICAR BOTAO OP4-
		menu.clicarPorTexto("(-)");

	// VERIFICAR OP4-
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
		
	// OPCAO 5 PARA ESQUERDA
		page.swipeElementLeft("Opção 5 (-)");
	
	// VERIFICAR OP5
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 5"));
	}
}
