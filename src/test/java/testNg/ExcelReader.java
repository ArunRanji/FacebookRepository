package testNg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReader {
	
	@Test(dataProviderClass =ExcelReader.class,dataProvider= "getData")
	public void login(String uname, String pwd) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		
	}

	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\TestData.xlsx");
		//step 1
		FileInputStream fis = new FileInputStream(f);
		
		//step 2
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3
		Sheet sheetName = wb.getSheet("Login");
		
		//step 4 to find rows and columns
		
		int rows = sheetName.getPhysicalNumberOfRows();
		System.out.println("Number of Rows : " + rows);  //4
		int columns = sheetName.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Numeber of Columns : "+ columns); //2
		
		//step 5
		
		DataFormatter format = new DataFormatter();
		
		String [][] testData = new String[rows-1][columns];
		for (int row = 1; row<rows; row++) {
			
			for(int col = 0; col<columns;col++) {
				
		testData[row-1][col]=	format.formatCellValue(sheetName.getRow(row).getCell(col));
		
		System.out.println(testData[row-1][col]);
			}	
		}
		return testData;
		
	}
}
