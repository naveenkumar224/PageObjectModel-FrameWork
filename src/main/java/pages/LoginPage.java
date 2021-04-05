package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonImplementation;

public class LoginPage extends CommonImplementation {

	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public LoginPage LeaftapsLoginPageURlLoad() throws IOException {
		FileInputStream file = new FileInputStream("src/main/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);

		driver.get(prop.getProperty("Application_URL"));

		return this;

	}

	public LoginPage EnterUsername() throws IOException {

		FileInputStream file = new FileInputStream("src/main/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		try {
			driver.findElement(By.id("username")).sendKeys(prop.getProperty("App_UN"));
			ReportStep(prop.getProperty("App_UN") + "UserName Logged in", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("UserName Not Logged in", "Fail");
		}
		return this;

	}

	public LoginPage EnterPassword() throws IOException {

		FileInputStream file = new FileInputStream("src/main/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		try {
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("App_PWD"));
			ReportStep(prop.getProperty("App_PWD") + "Password Logged in", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Password Not Logged in", "fail");
		}
		return this;

	}

	public LandingPage ClickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			ReportStep("Login Button is Clicked", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportStep("Login Button is not Clicked", "fail");
		}
		return new LandingPage(driver);

	}

}
