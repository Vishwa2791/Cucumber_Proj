package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WriteData {
	public static XSSFWorkbook wb;
	public static FileInputStream fis;
	public static File file;
	public static int cabRowIndex = 1, giftRowIndex = 1;
	
	public  void writeData(List<String> list) throws IOException {
		File file = new File(System.getProperty("user.dir") + "//reports//Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Determine the sheet index based on the existing sheets
	    int index = wb.getNumberOfSheets();

	    // Create a new sheet with the next available index
	    XSSFSheet sheet = wb.createSheet("Sheet" + (index + 1));

	    int rowIndex = sheet.getLastRowNum() + 1; // Start from the next available row

	    for (String item : list) {
	        XSSFRow row = sheet.createRow(rowIndex++);
	        row.createCell(0).setCellValue(item);
	    }

	    FileOutputStream fos = new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	}
	
	public static void writeTestNG(List<WebElement> place, List<WebElement> price, String sheetName) throws IOException {
		file = new File(System.getProperty("user.dir") + "//src//test//resources//TestNG_Input_Output_Book.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int rowIndex = 1;
		
		for (int i = 0; i < place.size(); i++) {
			XSSFRow row = sheet.createRow(rowIndex++);
	        row.createCell(0).setCellValue(place.get(i).getText().split("\n")[0]);
	        row.createCell(1).setCellValue(price.get(i).getText());
		}
		
		FileOutputStream fos = new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	}
	public static void writeCucumberCab(WebElement cab, WebElement price) throws IOException {
		file = new File(System.getProperty("user.dir") + "//src//test//resources//Cucumber_Input_Output_Book.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("OutstationCab");
		
		XSSFRow row = sheet.getRow(cabRowIndex++);
        row.createCell(7).setCellValue(cab.getText());
        row.createCell(8).setCellValue(price.getText());
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
	public static void writeCucumberGift(boolean result, boolean valid) throws IOException {
		file = new File(System.getProperty("user.dir") + "//src//test//resources//Cucumber_Input_Output_Book.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(valid?"ValidGiftCards":"InvalidGiftCards");
		
		XSSFRow row = sheet.getRow(valid?1:giftRowIndex);
		row.createCell(8).setCellValue(result?"PASS":"FAIL");
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
}
