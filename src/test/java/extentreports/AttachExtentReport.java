package extentreports;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
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

public class AttachExtentReport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter spark;
	File dest;

	@BeforeTest
	public void browserSetup() {

		spark = new ExtentSparkReporter("C:\\Users\\91888\\eclipse\\TestNG_7PMBatch\\reports\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
	}

	@Test
	public void loginCredential() throws IOException {
		test = extent.createTest("user to trying to login in the facebook page");
		try {
			driver.findElement(By.className("emaillll")).sendKeys("oranium");
		} catch (Exception e) {

			test.fail("Exception handled and the test case failed : " + e.getMessage());
			this.captureScreenshot();
			System.out.println("Exception handled");
		}
	}

	@Test
	public void verify() {
		test = extent.createTest("User trying to get the title");
		String title = driver.getTitle();
		if (title.equals("Facebook – log in or sign up")) {
			
			test.pass("Login page successfully verified");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

	public void captureScreenshot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/fb.png");
		FileHandler.copy(temp, dest);

		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());

	}

}
