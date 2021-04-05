package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.CommonImplementation;
import pages.LoginPage;

public class EditLead extends CommonImplementation {

	@BeforeClass
	public void FileReadName() {
		this.FileSheetName = "EditLead";

	}

	@Test(dataProvider = "ExcelRead")
	public void EditLeadTC(String FirstName, String CompanyName) throws InterruptedException, IOException {
		LoginPage obj = new LoginPage(driver);
		obj.LeaftapsLoginPageURlLoad().EnterUsername().EnterPassword().ClickLogin().Clickcrmsfa().ClicklLeadTab()
				.ClickFindLead().EnterFirstName(FirstName).ClickFindLeads().ClickFirstRecord().ClickEditLead()
				.EditCompanyName(CompanyName).clickSubmitButton().ValidateNewCompanyName(CompanyName);

	}

}
