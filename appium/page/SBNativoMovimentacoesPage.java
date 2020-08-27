package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class SBNativoMovimentacoesPage extends BasePage {

	public void escreverDescricao(String descricao) {
		escrever(By.xpath("//*[@text='Descrição']"), descricao);
	}
	
	public void escreverInteressado(String interessado) {
		escrever(By.xpath("//*[@text='Interessado']"), interessado);
	}
	
	public void escreverValor(String valor) {
		escrever(By.xpath("//*[@text='Valor']"), valor);

	}
	
	public void selecionarConta(String conta) {
		selecionarCombo(By.xpath("//*[@text='Selecione uma conta...']"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public boolean obterMensagemConta(String texto) {
		return obterTexto(By.xpath("//*[@text='"+texto+"']")) != null;
	}
}
