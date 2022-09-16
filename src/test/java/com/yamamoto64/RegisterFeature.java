package com.yamamoto64;

import org.junit.Assert;
import org.junit.Test;

import com.yamamoto64.pageobjects.RegisterPO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class RegisterFeature {

	@Test
	public void cant_register_with_differents_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;
		
		MobileElement registerButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		registerButton.click();
		
		RegisterPO registerPO = new RegisterPO(driver);
		registerPO.findElements();
		registerPO.register("Bugan", "123", "456");
		
		MobileElement confirmRegisterButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		confirmRegisterButton.click();
		MobileElement error = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
		Assert.assertEquals("Senhas não conferem", registerPO.errorMsgVerify());
		driver.navigate().back();
	}

	@Test
	public void can_register_with_same_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;
			
		MobileElement registerButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		registerButton.click();
		
		RegisterPO registerPO = new RegisterPO(driver);
		registerPO.findElements();
		registerPO.register("Bugan", "123", "123");
		
	}
}
