package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.AlertasPage;
import br.ce.erissonbreno.appium.page.MenuPage;

public class AlertTest extends BaseTest {

	
	MenuPage menu = new MenuPage();
	AlertasPage page = new AlertasPage();
	
	@Before
	public void inicio() {
		menu.acessarAlertas();
		}
			
	@Test
	public void deveConfirmarAlerta() {
		// CLICAR EM ALERTA CONFIRM
		page.deveClicarAlertaConfirm();
		
		// VERIFICAR TEXTOS
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		// CONFIRMAR ALERTA
		page.confirmar();
		
		// VERIFICAR NOVO TEXTO DE CONFIRMAÇÃO
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		// SAIR
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		// CLICAR ALERTA SIMPLES
		page.deveClicarAlertaSimples();
		
		// CLICAR FORA DA CAIXA
		esperar(1000);
		page.clicarForaCaixa();
		
		// VERIFICAR QUE A MENSAGEM NÃO ESTÁ MAIS PRESENTE
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
