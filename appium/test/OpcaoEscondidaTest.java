package br.ce.erissonbreno.appium.test;

import static br.ce.erissonbreno.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		
		// SCROLL DOWN
		WebDriverWait wait = new WebDriverWait(getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'Formulário']")));
		menu.scrollDown();
		
		// CLICAR MENU
		menu.clicarPorTexto("Opção bem escondida");
		
		// VERIFICAR MENSAGEM
		Assert.assertEquals("Você achou essa opção",menu.obterMensagemAlerta());
		
		// SAIR
		menu.clicarPorTexto("OK");
	}
}
