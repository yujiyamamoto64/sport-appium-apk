package com.yamamoto64.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPO extends BasePO {

	private MobileElement registerButton;

	public LoginPO(AppiumDriver driver) {
		super(driver);
	}

	@Override
	public void findElements() {
		registerButton = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
	}

	public RegisterPO goToLoginScren() {
		registerButton.click();
		return new RegisterPO(this.driver);
	}

}
