package com.yamamoto64.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegisterPO extends BasePO{
	
	private MobileElement nameForm;
	private MobileElement passForm;
	private MobileElement confirmPassForm;
	private MobileElement registerButton;
	private MobileElement errorMessage;
	
	private final By errorID;
	private final By nameFormID;
	private final By passFormID;
	private final By confirmPassFormID;
	private final By registerButtonID;
	
	protected RegisterPO(AppiumDriver driver) {
		super(driver);
		errorID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		nameFormID = By.id("br.com.alura.aluraesporte:id/input_nome");
		passFormID = By.id("br.com.alura.aluraesporte:id/input_senha");
		confirmPassFormID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		registerButtonID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	}
	
	@Override
	public void findElements() {
		nameForm = (MobileElement) driver.findElement(nameFormID);
		passForm = (MobileElement) driver.findElement(passFormID);
		confirmPassForm = (MobileElement) driver.findElement(confirmPassFormID);
		registerButton = (MobileElement) driver.findElement(registerButtonID);
	}
	
	private void fillForm(String user, String password, String confirmPass) {
		nameForm.setValue(user);
		passForm.setValue(password);
		confirmPassForm.setValue(confirmPass);
	}
	
	public LoginPO register(String user, String password, String confirmPass) {
		fillForm(user, password, confirmPass);
		registerButton.click();
		return new LoginPO(driver);
	}

	public String errorMsgVerify() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(errorID));
		
		errorMessage = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
		return errorMessage.getText();
	}
}
