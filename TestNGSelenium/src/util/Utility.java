package util;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Utility {
	 String projectPath=System.getProperty("user.dir");
	 static XSSFWorkbook workbook ;
	XSSFSheet sheet=workbook.getSheet("ebay");
	public Utility() {
		try {
			workbook =new XSSFWorkbook(projectPath+"//util/ebay_Registeration.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 
	
	public void getRowCount() throws IOException {
		
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		
	}
	public void getColCount() throws IOException {
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colCount);
		
	}
	
	public void getCelldata() throws IOException {
		
		 String celldata=sheet.getRow(0).getCell(0).getStringCellValue();
		 
	}
	
}
