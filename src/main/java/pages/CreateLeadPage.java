package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class CreateLeadPage extends CommonImplementation {

	public CreateLeadPage(ChromeDriver driver) {
		this.driver = driver;

	}

	public CreateLeadPage EnterCompanyName(String CompanName) throws IOException {

		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompanName);
			ReportStep(CompanName + "is Entered in Company name textbox", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Unable to Enter the Company Name", "fail");
		}
		return this;

	}

	public CreateLeadPage EnterFirstName(String FirstName) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
			ReportStep(FirstName + " is Entered in FirstName  textbox", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep(FirstName + " is not Entered in FirstName  textbox", "pass");
		}
		return this;
	}

	public CreateLeadPage EnterLastame(String lastName) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			ReportStep(lastName + " is Entered in lastName  textbox", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep(lastName + " is not Entered in lastName  textbox", "fail");
		}
		return this;
	}

	public CreateLeadPage EnterPhoneNumber(String PhoneNumber) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhoneNumber);
			ReportStep(PhoneNumber + " is Entered in PhoneNumber  textbox", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep(PhoneNumber + " is Entered in PhoneNumber  textbox", "fail");
		}
		return this;
	}

	public CreateLeadPage EnterEmailID(String EmailId) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(EmailId);
			ReportStep(EmailId + " is Entered in Emailid  textbox", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep(EmailId + " is not Entered in Emailid  textbox", "fail");
		}
		return this;
	}

	public ViewLeadPage ClickCreateLead() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
