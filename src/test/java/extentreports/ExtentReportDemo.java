package extentreports;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter spark;

	@BeforeTest
	public void start() {

		spark = new ExtentSparkReporter("C:\\Users\\91888\\eclipse\\TestNG_7PMBatch\\reports\\extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	}

	@Test
	public void login() {

		test = extent.createTest("login test").assignAuthor("Bala").assignCategory("smoke").assignDevice("chrome");
		test.log(Status.PASS, "Login page sign in sucessfully done");
	}

	@Test
	public void homePage() {

		test = extent.createTest("Home page test").assignAuthor("Suresh").assignCategory("Regression")
				.assignDevice("Edge");
		test.pass("Homepage testcase succefully passed");
	}

	@Test
	public void productPage() {

		test = extent.createTest("Product page test").assignAuthor("Oranium").assignCategory("smoke")
				.assignDevice("firefox");
		test.fail("Product page testcase got failed");

	}
	@AfterTest
	public void tearDown() {
		extent.flush();
		
	}
}
