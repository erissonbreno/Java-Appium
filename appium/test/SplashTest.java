package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.MenuPage;
import br.ce.erissonbreno.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		// ACESSAR MENU SPLASH
		menu.acessarSplash();
		
		// VERIFICAR SE O SPLASH ESTÁ SENDO EXIBIDO
		page.isTelaSplashVisivel();
		
		//AGUARDAR SAIDA DO SPLASH
		page.aguardarSplashSumir();
		
		// VERIFICAR QUE O FORMULÁRIO ESTÁ APARECENDO
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}
}
