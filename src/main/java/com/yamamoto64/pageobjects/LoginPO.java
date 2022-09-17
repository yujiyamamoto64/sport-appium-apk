package com.yamamoto64.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPO {

	private MobileElement registerButton;
	private AppiumDriver driver;

	public LoginPO(AppiumDriver driver) {
		this.driver = driver;
	}

	public void findElements() {
		registerButton = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
	}

	public RegisterPO goToLoginScren() {
		registerButton.click();
		return new RegisterPO(this.driver);
	}

}
