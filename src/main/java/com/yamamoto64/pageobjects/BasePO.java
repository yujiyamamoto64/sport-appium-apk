package com.yamamoto64.pageobjects;

import io.appium.java_client.AppiumDriver;

public abstract class BasePO {

	protected final AppiumDriver driver;
	
	protected BasePO(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public abstract void findElements();
}
