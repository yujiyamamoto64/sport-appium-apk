package com.yamamoto64.pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPO extends BasePO {

	private MobileElement registerButton;
	
	private final By registerButtonID;

	public LoginPO(AppiumDriver driver) {
		super(driver);
		registerButtonID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
	}

	@Override
	public void findElements() {
		registerButton = (MobileElement) driver.findElement(registerButtonID);
	}

	public RegisterPO goToLoginScren() {
		registerButton.click();
		return new RegisterPO(this.driver);
	}

}
