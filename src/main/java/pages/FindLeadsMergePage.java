package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class FindLeadsMergePage extends CommonImplementation {

	public FindLeadsMergePage(ChromeDriver driver) {
		this.driver = driver;

	}

	public FindLeadsMergePage ClickEnterFromlead(String FromLead) throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> FwindowHandles = driver.getWindowHandles();
		List<String> ListWindow = new ArrayList<String>(FwindowHandles);
		driver.switchTo().window(ListWindow.get(1));
		driver.findElement(By.name("id")).sendKeys(FromLead);
		driver.findElement(By.xpath("//td[@class='x-panel-btn-td']/table")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(ListWindow.get(0));
		return this;
	}

	public FindLeadsMergePage ClickEnterTolead(String ToLead) throws InterruptedException {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[last()]")).click();
		Set<String> SwindowHandles = driver.getWindowHandles();
		List<String> SList = new ArrayList<String>(SwindowHandles);
		driver.switchTo().window(SList.get(1));
		driver.findElement(By.name("id")).sendKeys(ToLead);
		driver.findElement(By.xpath("//td[@class='x-panel-btn-td']/table")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(SList.get(0));
		return this;
	}

	public MyLeadsPage ClickMergeButton() throws InterruptedException {
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		return new MyLeadsPage(driver);

	}
}
