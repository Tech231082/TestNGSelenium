package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

	}
	@Test(priority=2)
	public void test2() {
		boolean b=driver.findElement(By.className("gb_e")).isDisplayed();
		
	}
	
	@Test(priority=1)
	public void test() {
		String t=driver.getTitle();
		System.out.println(t);
	}
	
	@Test(priority=3)
	public void test1() {
		boolean b=driver.findElement(By.id("hplogo")).isDisplayed();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
