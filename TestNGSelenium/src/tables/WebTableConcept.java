package tables;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableConcept {

	public static void main(String[] args) throws IOException {
System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		////*[@id="customers"]/tbody/tr[2]/td[1]
		////*[@id="customers"]/tbody/tr[3]/td[1]
		////*[@id="customers"]/tbody/tr[7]/td[1]
		
		////*[@id="customers"]/tbody/tr[3]/td[2]
		////*[@id="customers"]/tbody/tr[7]/td[2]
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String before_xpath="//*[@id='customers']/tbody/tr[";
		String middle_xpath="]/td[";
		
		//XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\parmod.kumar\\git\\TestNGSelenium\\TestNGSelenium\\src\\util\\webTable.xlsx");
		//XSSFSheet sheet=book.createSheet("webTable");
		
		
		
				
		for(int i=2;i<7;i++) {
			for(int j=1;j<=3;j++) {
				String actual_xpath=before_xpath+i+middle_xpath+j+"]";
				System.out.println(driver.findElement(By.xpath(actual_xpath)).getText());
			}
		}
		
		System.out.println("Using list");
		
		List<WebElement>list=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount=list.size();
		int colCount=list.size();
		for(int i=2;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				System.out.println(list.get(i).getText());
			}
		}

	}

}
