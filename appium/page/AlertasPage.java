package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class AlertasPage extends BasePage {
	
	public void deveClicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void deveClicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void confirmar() {
		clicar(By.id("android:id/button2"));
	}

	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarForaCaixa() {
		tap(100, 150);
	}
}
