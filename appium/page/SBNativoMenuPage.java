package br.ce.erissonbreno.appium.page;

import br.ce.erissonbreno.appium.core.BasePage;

public class SBNativoMenuPage extends BasePage {

	public void entrarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void entrarMovimentacoes() {
		clicarPorTexto("MOV...");
	}
	
	public void entrarResumo() {
		clicarPorTexto("RESUMO");
	}
	
	public void entrarHome() {
		clicarPorTexto("HOME");
	}
}
