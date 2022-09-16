package com.yamamoto64.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegisterPO {

	private AppiumDriver driver;
	
	public MobileElement nameForm;
	public MobileElement passForm;
	public MobileElement confirmPassForm;
	public MobileElement registerButton;
	public MobileElement errorMessage;
	
	public RegisterPO(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void findElements() {
		nameForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		passForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		confirmPassForm = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		registerButton = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	}
	
	private void fillForm(String user, String password, String confirmPass) {
		nameForm.setValue(user);
		passForm.setValue(password);
		confirmPassForm.setValue(confirmPass);
	}
	
	public void register(String user, String password, String confirmPass) {
		fillForm(user, password, confirmPass);
		registerButton.click();
	}

	public String errorMsgVerify() {
		errorMessage = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
		return errorMessage.getText();
	}
}
