package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.CommonImplementation;

public class FindLeadsPage extends CommonImplementation {

	public FindLeadsPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public FindLeadsPage EnterFirstName(String FirstName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[last()]")).sendKeys(FirstName);
		return this;

	}

	public FindLeadsPage EnterLeadID(String FromLead) {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(FromLead);
		return this;

	}

	public void ValidateNoFromLead() {
		String Actual = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		String Expected = "No records to display";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(Actual, Expected);
		softassert.assertAll();

	}

	public FindLeadsPage ClickFindLeads() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[last()-1]")).click();
		Thread.sleep(3000);
		return this;

	}

	public ViewLeadPage ClickFirstRecord() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();

		return new ViewLeadPage(driver);
	}

	public FindLeadsPage ClickEmailTab() {
		driver.findElement(By.linkText("Email")).click();
		return this;

	}

	public FindLeadsPage EnterEmailId(String EmailId) {
		driver.findElement(By.name("emailAddress")).sendKeys(EmailId);
		return this;

	}

	public FindLeadsPage ClickPhoneTab() {
		driver.findElement(By.linkText("Phone")).click();
		return this;

	}

	public FindLeadsPage EnterPhoneNumber(String PhoneNumber) {
		driver.findElement(By.name("phoneNumber")).sendKeys(PhoneNumber);
		return this;

	}

	public FindLeadsPage ClickFindLeadsPhone() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		return this;

	}

	public FindLeadsPage ClickFindLeadsEmail() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		return this;

	}

}
