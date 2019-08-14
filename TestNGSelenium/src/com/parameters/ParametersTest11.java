package com.parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest11 {
	@Test
	@Parameters({"url","email","password"})
	public void test(String url,String email,String password) {
		//create prefs map to store all preferences
				Map<String,Object> prefs=new HashMap<String,Object>();
				
				//put this into prefs map to switch off browser notification
				prefs.put("profile.default_content_setting_values.notifications", 2);
				
				//create chrome options to set this prefs				
				ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				
				System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
				
				//launching chrome browser
				WebDriver driver=new ChromeDriver(options);
				
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.get(url);
				
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
				
				
				WebElement element1=driver.findElement(By.xpath("//input[@type='submit']"));
				element1.click();
	}

}
