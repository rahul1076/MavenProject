package com.loginpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	void setup() {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https:\\www.google.com");

	}

	@Test
	void loginTest() {

		// implicit wait
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		// explicit wait

		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

	static void click(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}

}
