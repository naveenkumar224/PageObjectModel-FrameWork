package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class EditLeadPage extends CommonImplementation {

	public EditLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public EditLeadPage EditCompanyName(String CompanyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(CompanyName);
		return this;

	}

	public ViewLeadPage clickSubmitButton() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage(driver);

	}

}
