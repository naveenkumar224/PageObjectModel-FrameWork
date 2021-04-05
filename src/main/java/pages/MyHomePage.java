package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class MyHomePage extends CommonImplementation {

	public MyHomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public MyLeadsPage ClicklLeadTab() throws IOException {
		try {
			driver.findElement(By.linkText("Leads")).click();
			ReportStep("Clicking on LeadsTab Button", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Not able to Click on LeadsTab Button", "fail");
		}
		return new MyLeadsPage(driver);

	}

}
