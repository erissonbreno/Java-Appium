package br.ce.erissonbreno.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.core.DriverFactory;
import br.ce.erissonbreno.appium.page.FormularioPage;
import br.ce.erissonbreno.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void deveEscreverNome() throws MalformedURLException {
		page.escreverNome("Breno");
		
		assertEquals("Breno", page.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		page.selecionarCombo("PS4");
		
		Assert.assertEquals("PS4", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Breno");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		page.clicarSalvar();

		Assert.assertEquals("Nome: Breno", page.verificaNome());
		Assert.assertTrue(page.verificaCheckbox().endsWith("Marcado"));
		Assert.assertTrue(page.verificaSwitch().endsWith("Off"));
		Assert.assertEquals("Console: switch", page.verificaConsole());
	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Breno");
		page.clicarSalvarDemorado();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text= 'Nome: Breno']")));
		Assert.assertEquals("Nome: Breno", page.verificaNome());

	}

	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("7");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("7/2/2000"));
		
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("7"));
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("7:10"));
		
	}
	
	@Test
	public void deveInteragirSeekBar() {
		// CLICAR NO SEEKBAR
		page.clicarSeekBar(0.98);
		
		// SALVAR
		page.clicarSalvar();
		
		// OBTER VALOR
	}

}
