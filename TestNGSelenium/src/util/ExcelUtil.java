package util;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static ArrayList<Object> getDataFromExcel() {
		ArrayList<Object> data=new ArrayList<Object>();
		try {
			//projectPath=System.getProperty("user.dir");
			 workbook = new XSSFWorkbook("C:\\JUnit\\eclipse-workspace\\TestNGSelenium\\src\\util\\ebay_Registeration.xlsx");
			 sheet=workbook.getSheet("ebay");
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		for(int i=2;i<sheet.getLastRowNum();i++) {
		String firstname=sheet.getRow(i).getCell(i).getStringCellValue();
		String lastname=sheet.getRow(i).getCell(i).getStringCellValue();
		String email=sheet.getRow(i).getCell(i).getStringCellValue();
		String password=sheet.getRow(i).getCell(i).getStringCellValue();
		
		Object[] ob= {firstname,lastname,email,password};
		data.add(ob);
	}
		return data;
}
}
