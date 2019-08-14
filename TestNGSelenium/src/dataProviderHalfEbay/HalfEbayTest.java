package dataProviderHalfEbay;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelUtil;

public class HalfEbayTest {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");

		// launching chrome browser
		driver = new ChromeDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg");
		
	}
	
	@DataProvider
	public Iterator<Object> fetchDataFromExcel() {
		ArrayList<Object> mydata=ExcelUtil.getDataFromExcel();
		return mydata.iterator();
	}
	
	
	@Test(dataProvider="fetchDataFromExcel")
	public void registerEbay(String firstname,String lastname,String email,String password) {
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		
	}

}
