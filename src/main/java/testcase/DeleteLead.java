package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.CommonImplementation;
import pages.LoginPage;

public class DeleteLead extends CommonImplementation {

	@BeforeClass
	public void FileReadName() {
		this.FileSheetName = "DeleteLead";

	}

	@Test(dataProvider = "ExcelRead")
	public void DeleteLead_TC(String PhoneNumber) throws InterruptedException, IOException {
		LoginPage obj = new LoginPage(driver);
		obj.LeaftapsLoginPageURlLoad().EnterUsername().EnterPassword().ClickLogin().Clickcrmsfa().ClicklLeadTab()
				.ClickFindLead().ClickPhoneTab().EnterPhoneNumber(PhoneNumber).ClickFindLeadsPhone().ClickFirstRecord()
				.ClickDeleteLead();

	}

}
