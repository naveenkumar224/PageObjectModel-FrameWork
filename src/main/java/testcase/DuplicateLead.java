package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.CommonImplementation;
import pages.LoginPage;

public class DuplicateLead extends CommonImplementation {

	@BeforeClass
	public void FileReadName() {
		this.FileSheetName = "DuplicateLead";

	}

	@Test(dataProvider = "ExcelRead")
	public void DuplicateLead_TC(String EmailId) throws InterruptedException, IOException {
		LoginPage obj = new LoginPage(driver);
		obj.LeaftapsLoginPageURlLoad().EnterUsername().EnterPassword().ClickLogin().Clickcrmsfa().ClicklLeadTab()
				.ClickFindLead().ClickEmailTab().EnterEmailId(EmailId).ClickFindLeadsEmail().ClickFirstRecord()
				.ClickDuplicateLead().ClickCreateLead();

	}

}
