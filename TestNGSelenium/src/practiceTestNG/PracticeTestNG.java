package practiceTestNG;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class PracticeTestNG extends BaseClass{
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		//create a map to store all prefs
		Map<String,Object> prefs=new HashMap<String,Object>();
		
		//put this into prefs map to shut the browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		//create chromeoptions to set this prefs
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");

		// launching chrome browser
		driver = new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		
		
	}
	
	@Test
	@Parameters({"email","password"})
	public void loginIntoFacebook(String email,String password) {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		
		
		WebElement element1=driver.findElement(By.xpath("//input[@type='submit']"));
		element1.click();
	}
	
	@Test(enabled=false)
	public void facebooktitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook - Log In or Sign Up","Title is correct");
		
	}

	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
