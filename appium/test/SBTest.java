package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.CliquesPage;
import br.ce.erissonbreno.appium.page.MenuPage;
import br.ce.erissonbreno.appium.page.SBNativoContasPage;
import br.ce.erissonbreno.appium.page.SBNativoHomePage;
import br.ce.erissonbreno.appium.page.SBNativoLoginPage;
import br.ce.erissonbreno.appium.page.SBNativoMenuPage;
import br.ce.erissonbreno.appium.page.SBNativoMovimentacoesPage;
import br.ce.erissonbreno.appium.page.SBNativoResumoPage;

public class SBTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBNativoLoginPage login = new SBNativoLoginPage();
	private SBNativoMenuPage menuSB = new SBNativoMenuPage();
	private SBNativoContasPage contas = new SBNativoContasPage();
	private CliquesPage clique = new CliquesPage();
	private SBNativoMovimentacoesPage mov = new SBNativoMovimentacoesPage();
	private SBNativoHomePage home = new SBNativoHomePage();
	private SBNativoResumoPage resumo = new SBNativoResumoPage();
	
	@Before
	public void fazerLogin() {
		menu.acessarSBNativo();
		login.setNome("e@breno");
		login.setSenha("123");
		login.entrar();
	}
	
	@Test
	public void inserirConta() {
		// ENTRAR EM CONTAS
		menuSB.entrarContas();
		// PREENCHER CAMPO 'Conta'
		contas.addConta("Farinha");
		// SALVAR
		contas.salvar();
		// VERIFICAR MENSAGEM
		Assert.assertTrue(contas.obterMensagemConta("Conta adicionada com sucesso"));
	}

	@Test
	public void excluirConta() {
		// ENTRAR EM CONTAS
		menuSB.entrarContas();
		// CLIQUE LONGO NA CONTA
		clique.cliqueLongo("Farinha");
		// EXCLUIR
		contas.clicarPorTexto("EXCLUIR");
		// VERIFICAR MENSAGEM
		Assert.assertTrue(contas.obterMensagemConta("Conta excluída com sucesso"));
	}
	
	@Test
	public void validarInclusaoMovimentacao() {
		// ENTRAR EM MOVIMENTACOES
		menuSB.entrarMovimentacoes();
		
		// VALIDAR DESCRICAO
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		mov.escreverDescricao("Dívida");
		
		// VALIDAR INTERESSADO
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		mov.escreverInteressado("O papa");
		
		// VALIDAR VALOR
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		mov.escreverValor("500");
		
		// VALIDAR CONTA
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		mov.selecionarConta("Conta para extrato");
		
		// SALVAR
		mov.salvar();
		
		// VERIFICAR MENSAGEM
		Assert.assertTrue(mov.obterMensagemConta("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deveAtualizarSaldoEExcluirMov() {
		// VERIFICAR SALDO 'Conta para saldo' = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		// IR PARA RESUMO
		menuSB.entrarResumo();
		
		// EXCLUIR MOVIMENTACA0 3
		resumo.excluirMov3();
		
		// VALIDAR MENSAGEM 'Movimentação removida com sucesso!'
		Assert.assertTrue(resumo.obterMensagemResumo("Movimentação removida com sucesso!"));
		
		// VOLTAR HOME
		menuSB.entrarHome();
		
		// ATUALIZAR SALDO (SCROLL DOWN)
		esperar(3000);
		resumo.atualizarPag();
		
		// VERIFICAR SALDO = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
