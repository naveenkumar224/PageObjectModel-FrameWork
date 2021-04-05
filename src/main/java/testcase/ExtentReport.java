package testcase;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public static void main(String[] args) throws IOException {

		ExtentHtmlReporter repo = new ExtentHtmlReporter("./Reports/result.html");
		ExtentReports exten = new ExtentReports();
		exten.attachReporter(repo);

		ExtentTest test = exten.createTest("Basic Login Step", "Login with valid Credentials along the Valid URL");
		test.pass("Username is passed Succesfully",
				MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/seats.png").build());
		test.pass("Password is passed succesfully");
		test.pass("Logged in Succesfully");

		test.assignAuthor("Naveen");
		test.assignCategory("Functionaly");

		exten.flush();

	}
}
