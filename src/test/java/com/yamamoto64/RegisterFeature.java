package com.yamamoto64;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

public class RegisterFeature {

	@Test
	public void cant_register_with_differents_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;
		
		MobileElement registerButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		registerButton.click();
		MobileElement nameForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement passForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement confirmPassForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		nameForm.setValue("Bugan");
		passForm.setValue("123");
		confirmPassForm.setValue("456");
		
		MobileElement confirmRegisterButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		confirmRegisterButton.click();
		MobileElement error = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
		
		Assert.assertEquals("Senhas não conferem", error.getText());
		driver.navigate().back();
	}

	@Test
	public void can_register_with_same_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;
			
		MobileElement registerButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		registerButton.click();
		MobileElement nameForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement passForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement confirmPassForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		nameForm.setValue("Bugan");
		passForm.setValue("123");
		confirmPassForm.setValue("123");
		
		MobileElement confirmRegisterButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		confirmRegisterButton.click();
	}
}
