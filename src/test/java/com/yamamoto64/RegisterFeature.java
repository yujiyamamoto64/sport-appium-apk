package com.yamamoto64;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.yamamoto64.pageobjects.LoginPO;
import com.yamamoto64.pageobjects.RegisterPO;

import io.appium.java_client.AppiumDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterFeature {

	@Test
	public void acant_register_with_differents_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;

		LoginPO loginPO = new LoginPO(driver);
		loginPO.findElements();

		RegisterPO registerPO = loginPO.goToLoginScren();
		registerPO.findElements();
		registerPO.register("Bugan", "123", "456");

		Assert.assertEquals("Senhas não conferem", registerPO.errorMsgVerify());
		driver.navigate().back();
	}

	@Test()
	public void bcan_register_with_same_passwords() {
		AppiumDriver driver = AppiumDriverConfig.instance().driver;

		LoginPO loginPO = new LoginPO(driver);
		loginPO.findElements();

		RegisterPO registerPO = loginPO.goToLoginScren();
		registerPO.findElements();

		loginPO = registerPO.register("Bugan", "123", "123");
		loginPO.findElements();
	}
}
