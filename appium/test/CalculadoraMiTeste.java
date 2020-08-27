package br.ce.erissonbreno.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraMiTeste {
	
	
	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    
	    MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("adição");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_3_s");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");
	    System.out.println(el5.getText());
	    Assert.assertEquals("= 5", el5.getText());
	    
	    driver.quit();
	}

}
