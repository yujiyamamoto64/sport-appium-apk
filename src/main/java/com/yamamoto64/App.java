package com.yamamoto64;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class App {

	public static void main(String[] args) throws MalformedURLException {
		File apk = new File("C:\\projetos\\sport-appium-apk\\src\\main\\resources\\alura_esporte.apk");
		
		DesiredCapabilities config = new DesiredCapabilities();
		config.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
		config.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		config.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		URL urlConnection = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver driver = new AppiumDriver<>(urlConnection, config);
	}
	
}
