package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class LandingPage extends CommonImplementation {

	public LandingPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public MyHomePage Clickcrmsfa() throws IOException {
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			ReportStep("Landing Page is Displayed properly", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Landing Page is not  Displayed properly", "Pass");
		}
		return new MyHomePage(driver);

	}

}
