package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.CommonImplementation;

public class ViewLeadPage extends CommonImplementation {

	public ViewLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public EditLeadPage ClickEditLead() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);

	}

	public MyLeadsPage ClickDeleteLead() {
		driver.findElement(By.linkText("Delete")).click();
		return new MyLeadsPage(driver);

	}

	public ViewLeadPage ValidateNewCompanyName(String CompanyName) {
		SoftAssert softassert = new SoftAssert();
		String actual = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		softassert.assertEquals(actual, CompanyName);
		System.out.println("Changed CompanyName Values is Updated");
		return this;

	}

	public DuplicateLeadPage ClickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);

	}
}
