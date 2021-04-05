package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.CommonImplementation;
import pages.LoginPage;

public class CreateLead extends CommonImplementation {

	@BeforeTest
	public void FileReadName() {
		this.FileSheetName = "CreateLead";
		this.TC_Name = "CreateLead";
		this.TC_Description = " Creating the Lead from the LeafTaps Application";
		this.TC_Author = "Naveen";
		this.TC_Category = "Smoke";

	}

	@Test(dataProvider = "ExcelRead")
	public void CreateLeadExecute(String CompanyName, String FirstName, String LastName, String PhoneNumber,
			String EmailId) throws IOException {
		LoginPage Tc = new LoginPage(driver);
		Tc.LeaftapsLoginPageURlLoad().EnterUsername().EnterPassword().ClickLogin().Clickcrmsfa().ClicklLeadTab()
				.ClickCreateLead().EnterCompanyName(CompanyName).EnterFirstName(FirstName).EnterLastame(LastName)
				.EnterPhoneNumber(PhoneNumber).EnterEmailID(EmailId).ClickCreateLead();
	}

}
