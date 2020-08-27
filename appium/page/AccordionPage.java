package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
	}
	
	public String verificarValorOp1() {
		return obterTexto(By.xpath("//*[@text ='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
