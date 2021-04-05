package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.CommonImplementation;
import pages.LoginPage;

public class MergeLead extends CommonImplementation {

	@BeforeClass
	public void FileReadName() {
		this.FileSheetName = "MergeLead";

	}

	@Test(dataProvider = "ExcelRead")
	public void MergeLead_TC(String FromLead, String ToLead) throws InterruptedException, IOException {
		LoginPage obj = new LoginPage(driver);
		obj.LeaftapsLoginPageURlLoad().EnterUsername().EnterPassword().ClickLogin().Clickcrmsfa().ClicklLeadTab()
				.ClickMergeLead().ClickEnterFromlead(FromLead).ClickEnterTolead(ToLead).ClickMergeButton()
				.ClickFindLead().EnterLeadID(FromLead);

	}

}
