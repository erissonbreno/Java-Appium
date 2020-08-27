package br.ce.erissonbreno.appium.page;

import org.openqa.selenium.By;

import br.ce.erissonbreno.appium.core.BasePage;

public class SBNativoLoginPage extends BasePage {

	public void setNome(String nome) {
		escrever(By.xpath("//*[@text='Nome']"), nome);
	}
	
	public void setSenha(String senha) {
		escrever(By.xpath("//*[@text='Senha']"), senha);
	}
	
	public void entrar() {
		clicarPorTexto("ENTRAR");
	}


}
