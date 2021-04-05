package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class DuplicateLeadPage extends CommonImplementation {

	public DuplicateLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public ViewLeadPage ClickCreateLead() {
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		return new ViewLeadPage(driver);
	}

}
