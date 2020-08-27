package br.ce.erissonbreno.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.MenuPage;
import br.ce.erissonbreno.appium.page.WebViewPage;

public class WebViewTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		// ACESSAR O MENU
		menu.acessarSeuBarrigaHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		// PREENCHER EMAIL
		page.setEmail("erissonbreno@hotmail.com");
		
		// SENHA
		page.setSenha("04011960");
		
		// ENTRAR
		page.entrar();
		
		// VERIFICAR MENSAGEM
		Assert.assertEquals("Bem vindo, Erisson!",page.getMensagem());
		
	}
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
