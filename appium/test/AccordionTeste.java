package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.AccordionPage;
import br.ce.erissonbreno.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		// ACESSAR MENU
		menu.acessarAccordion();
		
		// CLICAR OPCAO 1
		page.selecionarOp1();
		
		// VERIFICAR TEXTO DA OPCAO 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.verificarValorOp1());	
	}

}
