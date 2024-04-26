package extentreports;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportExample {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter spark;
	
	@BeforeTest
	public void launchBrowser() {
		spark = new ExtentSparkReporter("C:\\Users\\91888\\eclipse\\TestNG_7PMBatch\\reports\\extentexample.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void openGoogle() throws IOException {
		
		test = extent.createTest("gogole test case");
		test.log(Status.INFO,"Navigating to google page");
		driver.get("https://www.google.co.in/");
		
		String title = driver.getTitle();
		test.log(Status.INFO, "Actual title : "+ title);
		test.log(Status.INFO, "Expected title : "+ "google");
		test.log(Status.INFO, "Verification of Actual & Expected Title");

		if (title.equals("google")) {

			System.out.println("TitleMatched");
			test.log(Status.PASS, "Actual title and expected title or equal");
		} else {
			
			test.log(Status.FAIL, "Actual title and expected title or not  equal");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshotfail/fb.png");
			FileHandler.copy(temp, dest);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath("./screenshotfail/fb.png").build());
			
		}

	}
	
	@AfterTest
	public void quit() {
		
		driver.quit();
		extent.flush();
	}
}
