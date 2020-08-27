package br.ce.erissonbreno.appium.page;

import static br.ce.erissonbreno.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;

public class CliquesPage extends MenuPage {

	public void cliqueLongo(String texto) {
		new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text = '"+texto+"']"))).perform();
	}
	
	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
