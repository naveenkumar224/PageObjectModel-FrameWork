package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class MyLeadsPage extends CommonImplementation {

	public MyLeadsPage(ChromeDriver driver) {
		this.driver = driver;

	}

	public CreateLeadPage ClickCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			ReportStep("Clicked on Create Lead link", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Not Clicked on Create Lead link", "fail");
		}
		return new CreateLeadPage(driver);

	}

	public FindLeadsPage ClickFindLead() {

		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadsPage(driver);

	}

	public FindLeadsMergePage ClickMergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new FindLeadsMergePage(driver);

	}

}
