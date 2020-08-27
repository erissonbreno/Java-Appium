package br.ce.erissonbreno.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.erissonbreno.appium.core.BaseTest;
import br.ce.erissonbreno.appium.page.DragNDropPage;
import br.ce.erissonbreno.appium.page.MenuPage;

public class DragAndDropTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	@Test
	public void deveEfetuarDragNDrop() {
		// ACESSAR MENU
		menu.scrollDown();
		menu.acessarDragAndDrop();
		
		// VERIFICAR ESTADO INICIAL
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		// ARRASTAR "Esta" PARA "e arraste para"
		page.arrastar("Esta", "e arraste para");
		
		// VERIFICAR ESTADO INTERMEDIARIO
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());

		// ARRASTAR "Fa�a um clique longo," PARA "� uma lista"
		page.arrastar("Fa�a um clique longo,", "� uma lista");
		
		// VERIFICAR ESTADO FINAL
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
