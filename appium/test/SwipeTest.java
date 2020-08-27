package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe(){
		// DEVE ACESSAR MENU
		menu.acessarSwipe();
		
		// VERIFICAR TEXTO 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		// SWIPE PARA DIREITA
		menu.swipeRight();
		
		// VERIFICAR TEXTO 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));		
		
		// CLICAR BOTAO DIREITA
		menu.clicarPorTexto("›");
		
		// VERIFICAR TEXTO 'Chegar até o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));		
		
		// SWIPE PARA ESQUERDA
		menu.swipeLeft();
		
		// CLICAR BOTAO ESQUERDA
		menu.clicarPorTexto("‹");
		
		// VERIFICAR TEXTO 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
