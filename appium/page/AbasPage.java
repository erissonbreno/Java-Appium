package br.ce.erissonbreno.appium.page;

import br.ce.erissonbreno.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public boolean isAba1() {
		return existeElementoPorTexto("Este � o conte�do da Aba 1");
	}

	public boolean isAba2() {
		return existeElementoPorTexto("Este � o conte�do da Aba 2");
	}
	
	public void clicarAba2() {
		clicarPorTexto("ABA 2");
	}

}