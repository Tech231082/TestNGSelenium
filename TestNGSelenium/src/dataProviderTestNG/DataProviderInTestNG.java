package dataProviderTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.util.TestUtility;

public class DataProviderInTestNG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		
		//launching chrome browser
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		WebElement locator=driver.findElement(By.xpath("//a[contains(text(),'Login & Signup')]"));
		
		new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(locator));
		
		
        
		//element was not clickable so using javascriptexecutor
		//WebElement element=driver.findElement(By.xpath("//a[contains(text(),'New to Flipkart? Create an account')]"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click", element);
		
		//WebElement e1=driver.findElement(By.xpath("//input[@class='_2zrpKA F_Atl2 _1dBPDZ']"));
		//js.executeScript("arguments[0].sendKeys)", e1);
		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data=TestUtility.getTestData("dataprovider");
		return data;
	}
	
	@Test(dataProvider="getTestData")
	public void loginPageTest(String email,String password) {
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//descendant::input[@class='_2zrpKA _1dBPDZ']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
