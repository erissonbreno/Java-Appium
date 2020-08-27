package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class SBNativoResumoPage extends BasePage {
	
	private SwipeListPage swipe = new SwipeListPage();

	public void excluirMov3() {
		swipe.swipeElementRight("Movimentacao 3, calculo saldo");
		clicarPorTexto("Del");
	}
	
	public boolean obterMensagemResumo(String texto) {
		return obterTexto(By.xpath("//*[@text='"+texto+"']")) != null;
	}
	
	public void atualizarPag() {
		scroll(0.3, 0.9);
	}
}
