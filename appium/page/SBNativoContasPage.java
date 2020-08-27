package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class SBNativoContasPage extends BasePage {
	public void addConta(String conta) {
		escrever(By.xpath("//android.widget.EditText"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public boolean obterMensagemConta(String texto) {
		return obterTexto(By.xpath("//*[@text='"+texto+"']")) != null;
	}

}
