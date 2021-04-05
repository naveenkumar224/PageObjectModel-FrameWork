package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonImplementation extends POM_ExcelRead {

	public ChromeDriver driver;
	public String FileSheetName;
	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	public String TC_Name, TC_Description, TC_Author, TC_Category;
	public static ExtentTest test, node;

	@BeforeSuite
	public void StartReport() {
		report = new ExtentHtmlReporter("./Reports/TestExecution.html");
		report.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(report);

	}

	@BeforeClass
	public void TestDescription() {

		test = extent.createTest(TC_Name, TC_Description);
		test.assignAuthor(TC_Author);
		test.assignCategory(TC_Category);

	}

	public int takesnap() throws IOException {
		int SnapNumber = (int) (Math.random() * 90000);
		File Source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Snaps/img" + SnapNumber + ".png");
		FileUtils.copyFile(Source, destination);
		return SnapNumber;

	}

	public void ReportStep(String msg, String Status) throws IOException {

		if (Status.equalsIgnoreCase("pass")) {
			node.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img" + takesnap() + ".png").build());
		} else if (Status.equalsIgnoreCase("fail")) {
			node.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img" + takesnap() + ".png").build());
			throw new RuntimeException();
		}

	}

	@BeforeMethod
	public void Precondition() {
		node = test.createNode(TC_Name);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void PostCondition() {

		driver.quit();

	}

	@DataProvider(name = "ExcelRead")
	public String[][] ExcelReadData() throws IOException {
		POM_ExcelRead obj = new POM_ExcelRead();
		return obj.ReadingExcelData(FileSheetName);

	}

	@AfterSuite
	public void Closereport() {
		extent.flush();
	}

}
