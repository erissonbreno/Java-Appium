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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'Formul�rio']")));
		menu.scrollDown();
		
		// CLICAR MENU
		menu.clicarPorTexto("Op��o bem escondida");
		
		// VERIFICAR MENSAGEM
		Assert.assertEquals("Voc� achou essa op��o",menu.obterMensagemAlerta());
		
		// SAIR
		menu.clicarPorTexto("OK");
	}
}
